package com.zuhaproject.stock_analyzer.stockanalyzer.repository;

import com.zuhaproject.stock_analyzer.stockanalyzer.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
    Optional<StockPrice> findTopBySymbolOrderByDateDesc(String symbol); // WILL GET LATEST PRICE
    List<StockPrice> findAllBySymbolOrderByDateDesc(String symbol); //WILL GET ALL PRICES
}
