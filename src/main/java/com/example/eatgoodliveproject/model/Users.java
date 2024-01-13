package com.example.eatgoodliveproject.model;

import com.example.eatgoodliveproject.enums.CountryCode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String confirmPassword;
    private String profilePictureUrl;
    private CountryCode countryCode;
    private Long phoneNumber;
    private Address address;
    private String City;
    private String Country;

}
