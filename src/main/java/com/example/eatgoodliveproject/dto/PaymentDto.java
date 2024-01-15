package com.example.eatgoodliveproject.dto;

import com.example.eatgoodliveproject.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private PaymentMethod paymentMethod;
}
