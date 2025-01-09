package com.example.micro.front.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.micro.front.main.entities.Product;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.back.url}")
    private String serviceBackUrl;

    @GetMapping
    public List<Product> getCart() {
        ResponseEntity<Product[]> response = restTemplate.getForEntity(serviceBackUrl, Product[].class);
        return Arrays.asList(response.getBody());
    }

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        restTemplate.postForEntity(serviceBackUrl, product, String.class);
        return ("Product: " + product.getName() + " was added successfully");
    }

    @DeleteMapping("/{id}")
    public String removeProduct(@PathVariable String id) {
        restTemplate.delete(serviceBackUrl + "/" + id);
        return ("Product " + id + " removed from cart!");
    }
}
