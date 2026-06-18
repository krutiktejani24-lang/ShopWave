package com.shopwave.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "ShopWave Backend Running Successfully";
    }

    @GetMapping("/test")
    public String test() {
        return "Test Working";
    }
}