package com.shopwave.controller;
import java.util.Optional;
import com.shopwave.security.JwtUtil;
import com.shopwave.entity.User;
import com.shopwave.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {
    "http://127.0.0.1:5500",
    "https://shopwave-1-nwj2.onrender.com"
})  
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        Optional<User> existingUser =
                userRepository.findByEmail(user.getEmail());

        if (existingUser.isPresent() &&
    existingUser.get().getPassword().equals(user.getPassword())) {

    String token =
        JwtUtil.generateToken(user.getEmail());

    return ResponseEntity.ok(token);
}

        return ResponseEntity.status(401).body("Invalid Credentials");
    }

    @GetMapping("/all")
public List<User> getAllUsers() {
    return userRepository.findAll();
}
}   