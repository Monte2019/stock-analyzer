package com.zuhaproject.stock_analyzer.stockanalyzer.controller;

import com.zuhaproject.stock_analyzer.stockanalyzer.model.StockPrice;
import com.zuhaproject.stock_analyzer.stockanalyzer.repository.StockPriceRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockPriceRepository repository;

    public StockController(StockPriceRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public StockPrice addStock(@RequestBody StockPrice stockPrice){
        return repository.save(stockPrice);
    }

    @GetMapping
    public List<StockPrice> getAll() {
        return repository.findAll();
    }
}
