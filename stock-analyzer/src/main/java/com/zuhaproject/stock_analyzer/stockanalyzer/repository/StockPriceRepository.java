package com.zuhaproject.stock_analyzer.stockanalyzer.repository;

import com.zuhaproject.stock_analyzer.stockanalyzer.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
