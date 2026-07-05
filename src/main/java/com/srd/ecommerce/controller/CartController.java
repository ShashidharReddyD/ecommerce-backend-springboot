package com.srd.ecommerce.controller;

import com.srd.ecommerce.entity.Cart;
import com.srd.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam Long userId,
                            @RequestParam Long productId,
                            @RequestParam Integer quantity) {

        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable Long userId) {

        return cartService.getCart(userId);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable Long cartItemId) {

        return cartService.removeItem(cartItemId);
    }

}