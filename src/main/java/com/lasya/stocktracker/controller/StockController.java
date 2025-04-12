package com.lasya.stocktracker.controller;

import com.lasya.stocktracker.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class StockController {

    @Autowired
    private StockService stockService;

    // Health check
    @GetMapping
    public String testEndpoint() {
        return "Stock Tracker API is running!";
    }

    // Test stock fetching
    @GetMapping("/stocks/{symbol}")
    public double getStock(@PathVariable String symbol) {
        return stockService.getStockPrice(symbol);
    }
}
