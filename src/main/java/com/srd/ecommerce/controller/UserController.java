package com.srd.ecommerce.controller;

import com.srd.ecommerce.dto.RegisterRequest;
import com.srd.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.srd.ecommerce.dto.LoginRequest;
import com.srd.ecommerce.dto.LoginResponse;


@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest request) {

        return userService.registerUser(request);

    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        return userService.loginUser(request);

    }
}