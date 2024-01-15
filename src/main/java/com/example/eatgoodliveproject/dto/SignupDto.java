package com.example.eatgoodliveproject.dto;


import com.example.eatgoodliveproject.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupDto {
    private Long id;
    private String fullName;
    private String username;
    private String countryCode;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}

