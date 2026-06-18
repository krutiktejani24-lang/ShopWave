package com.shopwave.controller;

import com.shopwave.entity.WishlistItem;
import com.shopwave.repository.WishlistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin("*")
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;

    @PostMapping("/add")
    public WishlistItem add(@RequestBody WishlistItem item) {
        return wishlistRepository.save(item);
    }

    @GetMapping("/{userId}")
    public List<WishlistItem> getWishlist(
            @PathVariable Long userId) {

        return wishlistRepository.findByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable Long id) {

        wishlistRepository.deleteById(id);
        return "Wishlist Item Removed";
    }
}