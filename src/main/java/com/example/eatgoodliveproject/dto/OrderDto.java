package com.example.eatgoodliveproject.dto;

import com.example.eatgoodliveproject.enums.TrackingStatus;
import com.example.eatgoodliveproject.model.Payment;
import com.example.eatgoodliveproject.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Users user;
    private BigDecimal totalAmount;
    private Payment payment;
    private TrackingStatus status;
}
