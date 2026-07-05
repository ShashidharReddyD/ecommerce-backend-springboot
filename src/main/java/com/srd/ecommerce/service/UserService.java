package com.srd.ecommerce.service;

import com.srd.ecommerce.dto.RegisterRequest;
import com.srd.ecommerce.entity.Role;
import com.srd.ecommerce.entity.User;
import com.srd.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // We'll encrypt later
        user.setRole(Role.USER);

        userRepository.save(user);

        return "User Registered Successfully";
    }
}