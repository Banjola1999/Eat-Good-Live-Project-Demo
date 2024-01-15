package com.example.eatgoodliveproject.dto;

import com.example.eatgoodliveproject.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private Product product;
    private Long quantity;
    private BigDecimal orderedProductPrice;
}
