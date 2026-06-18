package com.shopwave.controller;

import com.shopwave.entity.Order;
import com.shopwave.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Order order) {

        order.setStatus("PLACED");
        return orderRepository.save(order);
    }

    @GetMapping("/user/{userId}")
public List<Order> getOrdersByUser(@PathVariable Long userId) {
    return orderRepository.findByUserId(userId);
}
}