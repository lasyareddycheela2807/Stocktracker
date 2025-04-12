package com.lasya.stocktracker.repository;

import com.lasya.stocktracker.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findBySymbol(String symbol);  // Custom method to find stock by symbol
}
