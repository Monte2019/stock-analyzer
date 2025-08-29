package com.zuhaproject.stock_analyzer.stockanalyzer.controller;

import com.zuhaproject.stock_analyzer.stockanalyzer.model.StockPrice;
import com.zuhaproject.stock_analyzer.stockanalyzer.repository.StockPriceRepository;
import com.zuhaproject.stock_analyzer.stockanalyzer.service.YahooFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockPriceController {
    @Autowired
    private StockPriceRepository stockPriceRepository;
    private final StockPriceRepository repository;
    private YahooFinanceService yahooFinanceService;

    public StockPriceController(StockPriceRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<StockPrice> getAllStocks() {
        return repository.findAll();
    }

    //WANT LATEST PRICE OF CERTAIN STOCK
    @GetMapping("/{symbol}")
    public ResponseEntity<StockPrice> getLatestStockBySymbol(@PathVariable String symbol) {
        return stockPriceRepository.findTopBySymbolOrderByDateDesc(symbol.toUpperCase())
                                   .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //WANT ALL PRICES OF STOCK (history)
    @GetMapping("/{symbol}/history")
    public List<StockPrice> getAllStockPricesBySymbol(@PathVariable String symbol) {
        return stockPriceRepository.findAllBySymbolOrderByDateDesc(symbol.toUpperCase());
    }

    @PostMapping
    public ResponseEntity<StockPrice> addStock(@RequestBody StockPriceRequest request) {
        StockPrice stock = new StockPrice();
        stock.setSymbol(request.name);
        stock.setPrice(request.price);
        stock.setDate(request.date);
        return ResponseEntity.ok(stockPriceRepository.save(stock));
    }

    //Yahoo Finance Endpoint

    @GetMapping("/{symbol}/live")
    public ResponseEntity<?> getLiveStockPrice(@PathVariable String symbol) {
        try {
            BigDecimal price = yahooFinanceService.getPrice(symbol.toUpperCase());
            return ResponseEntity.ok(price);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to fetch live price");
        }
    }

}
