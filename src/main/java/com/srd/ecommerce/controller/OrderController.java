package com.srd.ecommerce.controller;

import com.srd.ecommerce.entity.CustomerOrder;
import com.srd.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam Long userId) {

        return orderService.placeOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<CustomerOrder> getOrders(@PathVariable Long userId) {

        return orderService.getOrders(userId);
    }

    @PutMapping("/cancel/{orderId}")
    public String cancelOrder(@PathVariable Long orderId) {

        return orderService.cancelOrder(orderId);
    }

}