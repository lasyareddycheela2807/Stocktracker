package com.lasya.stocktracker.controller;

import com.lasya.stocktracker.dto.LoginRequest;
import com.lasya.stocktracker.model.User;
import com.lasya.stocktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        System.out.println("pl");
        return userService.registerUser(user);
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//        System.out.println("pp");
//        String result = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
//        if (result.equals("Login successful!")) {
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.status(401).body(result);
//        }
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser() {
//        System.out.println("pp");
//        String result = userService.loginUser("lasya@example.com", "secret123");
//        return ResponseEntity.ok(result);
//    }






//@PostMapping("/login")
//public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//    System.out.println("pp");
//    return ResponseEntity.ok("test");
//}


//@PostMapping("/login")
//public ResponseEntity<String> loginUser() {
//    System.out.println("pp");
//    return ResponseEntity.ok("test");
//}
//@PostMapping("/login")
//public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
//    System.out.println("pp");
//
//    if (loginRequest == null) {
//        System.out.println("loginRequest is null 😢");
//        return ResponseEntity.status(400).body("Bad Request: loginRequest is null");
//    }
//
//    System.out.println("email = " + loginRequest.getEmail());
//    System.out.println("password = " + loginRequest.getPassword());
//
//    String result = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
//    return ResponseEntity.ok(result);
//}
//
//@PostMapping("/login")
//public LoginRequest test(@RequestBody LoginRequest loginRequest) {
//    System.out.println("Inside test: " + loginRequest.getEmail() + " - " + loginRequest.getPassword());
//    return loginRequest;
//}

@PostMapping("/login")
public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
    System.out.println("pp");

    try {
        System.out.println("email = " + loginRequest.getEmail());
        System.out.println("password = " + loginRequest.getPassword());

        String result = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.ok(result);

    } catch (Exception e) {
        e.printStackTrace(); // 🔥 This will show the full exception in the console
        return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
    }
}




}
