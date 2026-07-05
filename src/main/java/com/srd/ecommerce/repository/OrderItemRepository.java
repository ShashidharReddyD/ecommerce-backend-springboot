package com.srd.ecommerce.repository;

import com.srd.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository
        extends JpaRepository<OrderItem, Long> {
}