//package com.lasya.stocktracker.model;
//
//import jakarta.persistence.*;
//import lombok.ToString;
//
//import java.util.*;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(unique = true)
//    private String username;
//
//    @Column(unique = true)
//    private String email;
//
//    private String password;
//
//    // later we'll map watchlist here using OneToMany
//    // private List<Watchlist> watchlist;
//
//    // Constructors
//    public User() {}
//
//    public User(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.password = password;
//    }
//
//    // Getters & Setters
//    public Long getId() { return id; }
//
//    public String getUsername() { return username; }
//    public void setUsername(String username) { this.username = username; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
//}


package com.lasya.stocktracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "watchlist") // to avoid infinite recursion in toString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // One user can have multiple watchlist items
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WatchlistItem> watchlist;
}
