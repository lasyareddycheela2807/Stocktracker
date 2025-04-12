//package com.lasya.stocktracker.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "stocks")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Stock {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;  // Primary key
//
//
//    @Column(nullable = false, unique = true)
//    private String symbol;
//    @Column(nullable = false)
//    private double price;  // Current stock price
//
//    @Column(nullable = false)
//    private double changePercentage;  // Percentage change from last price
//
//    @Column(nullable = false)
//    private String lastUpdated;  // Timestamp of the last update
//}


package com.lasya.stocktracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private double price;  // Current stock price

    @Column(nullable = false)
    private double changePercentage;  // Percentage change from last price

    @Column(nullable = false)
    private String lastUpdated;  // Timestamp of the last update

    // 👇 Relationship: Many stocks belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
