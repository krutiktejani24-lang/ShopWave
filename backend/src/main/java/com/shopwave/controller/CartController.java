package com.shopwave.controller;

import com.shopwave.entity.CartItem;
import com.shopwave.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartRepository.save(item);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String removeCartItem(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return "Item Removed";
    }
}