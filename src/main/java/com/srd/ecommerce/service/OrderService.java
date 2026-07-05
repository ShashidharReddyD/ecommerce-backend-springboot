package com.srd.ecommerce.service;

import com.srd.ecommerce.entity.*;
import com.srd.ecommerce.repository.CartRepository;
import com.srd.ecommerce.repository.CustomerOrderRepository;
import com.srd.ecommerce.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import com.srd.ecommerce.entity.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final CustomerOrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartRepository cartRepository;

    public OrderService(CustomerOrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        CartRepository cartRepository) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartRepository = cartRepository;
    }

    public String placeOrder(Long userId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));

        if (cart.getItems().isEmpty()) {
            return "Cart is Empty";
        }

        CustomerOrder order = new CustomerOrder();
        order.setUserId(userId);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PLACED);

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());

            order.getItems().add(orderItem);
        }

        orderRepository.save(order);

        cart.getItems().clear();
        cartRepository.save(cart);

        return "Order Placed Successfully";
    }

    public List<CustomerOrder> getOrders(Long userId) {

        return orderRepository.findByUserId(userId);
    }

    public String cancelOrder(Long orderId) {

        CustomerOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order Not Found"));

        order.setStatus(OrderStatus.CANCELLED);

        orderRepository.save(order);

        return "Order Cancelled Successfully";
    }

}