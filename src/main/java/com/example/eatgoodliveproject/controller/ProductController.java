package com.example.eatgoodliveproject.controller;

import com.example.eatgoodliveproject.dto.ProductDto;
import com.example.eatgoodliveproject.model.Product;
import com.example.eatgoodliveproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto product){
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return productService.getAll();
    }


}
