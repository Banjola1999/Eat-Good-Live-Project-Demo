package com.example.eatgoodliveproject.service;

import com.example.eatgoodliveproject.dto.ProductDto;
import com.example.eatgoodliveproject.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<String> addProduct(ProductDto product);

    ResponseEntity<List<Product>> getAll();
}
