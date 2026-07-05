package com.srd.ecommerce.repository;

import com.srd.ecommerce.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository
        extends JpaRepository<CartItem, Long> {
}