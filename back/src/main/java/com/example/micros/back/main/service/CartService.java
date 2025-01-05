package com.example.micros.back.main.service;

import org.springframework.stereotype.Service;

import com.example.micros.back.main.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<Product> cart = new ArrayList<>();

    public List<Product> getCart() {
        return cart;
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void removeProduct(String productId) {
        cart.removeIf(product -> product.getId().equals(productId));
    }
}
