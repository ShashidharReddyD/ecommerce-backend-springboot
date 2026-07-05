package com.srd.ecommerce.service;

import com.srd.ecommerce.entity.Cart;
import com.srd.ecommerce.entity.CartItem;
import com.srd.ecommerce.entity.Product;
import com.srd.ecommerce.repository.CartItemRepository;
import com.srd.ecommerce.repository.CartRepository;
import com.srd.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository,
                       CartItemRepository cartItemRepository,
                       ProductRepository productRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public String addToCart(Long userId, Long productId, Integer quantity) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUserId(userId);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));

        CartItem item = new CartItem();
        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        cartItemRepository.save(item);

        return "Product Added To Cart";
    }

    public Cart getCart(Long userId) {

        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart Not Found"));
    }

    public String removeItem(Long cartItemId) {

        if (!cartItemRepository.existsById(cartItemId)) {
            return "Item Not Found";
        }

        cartItemRepository.deleteById(cartItemId);

        return "Item Removed Successfully";
    }

}