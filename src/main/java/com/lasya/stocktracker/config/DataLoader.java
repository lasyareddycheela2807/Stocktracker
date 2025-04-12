package com.lasya.stocktracker.config;

import com.lasya.stocktracker.model.Stock;
import com.lasya.stocktracker.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(StockRepository stockRepository) {
        return args -> {
            stockRepository.saveAll(List.of(

            ));
        };
    }
}
