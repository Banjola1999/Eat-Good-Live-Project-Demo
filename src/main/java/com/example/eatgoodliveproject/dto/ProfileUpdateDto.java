package com.example.eatgoodliveproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDto {
    private String fullName;
    private String username;
    private String profilePictureUrl;
    private String countryCode;
    private Long phoneNumber;
    private String homeAddress;
    private String City;
    private String Country;

}
