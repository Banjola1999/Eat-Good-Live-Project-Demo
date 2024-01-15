package com.example.eatgoodliveproject.serviceimpl;

import com.example.eatgoodliveproject.dto.ProductDto;
import com.example.eatgoodliveproject.enums.DishType;
import com.example.eatgoodliveproject.model.Product;
import com.example.eatgoodliveproject.repositories.ProductRepository;
import com.example.eatgoodliveproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<String> addProduct(ProductDto product) {
        Product product1 = new Product();
        product1.setCategory(DishType.GRILLED__ROASTED_FOODS);
        product1.setPrice(new BigDecimal(750000));
        product1.setSize(500L);
        product1.setDish(product.getDish());
        product1.setDishImageUrl(product.getDishImageUrl());
        productRepository.save(product1);
        return ResponseEntity.ok("Product added");
    }

    @Override

    public ResponseEntity<List<Product>> getAll() {
        List<Product> productList =  productRepository.findAll();
        return ResponseEntity.ok(productList);
    }
}
