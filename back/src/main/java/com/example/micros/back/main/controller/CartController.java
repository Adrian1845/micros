package com.example.micros.back.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.micros.back.main.entities.Product;
import com.example.micros.back.main.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Product> getCart() {
        return cartService.getCart();
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        cartService.addProduct(product);
        return "Product added to cart!";
    }

    @DeleteMapping("/{id}")
    public String removeProduct(@PathVariable String id) {
        cartService.removeProduct(id);
        return "Product removed from cart!";
    }
}
