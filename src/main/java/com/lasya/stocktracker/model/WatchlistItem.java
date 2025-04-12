package com.lasya.stocktracker.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watchlist_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WatchlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companySymbol;

    @ManyToOne
    @JoinColumn(name = "user_id")  // FK to User table
    private User user;
}
