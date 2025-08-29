package com.zuhaproject.stock_analyzer.stockanalyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome to the Stock Analyzer API!";
    }
}
