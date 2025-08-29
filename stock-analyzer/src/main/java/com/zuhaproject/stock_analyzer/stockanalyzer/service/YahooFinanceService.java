package com.zuhaproject.stock_analyzer.stockanalyzer.service;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

public class YahooFinanceService {

    public BigDecimal getPrice(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        return stock.getQuote().getPrice();
    }

    public Stock getFullStockData(String symbol) throws IOException {
        return YahooFinance.get(symbol);
    }
}
