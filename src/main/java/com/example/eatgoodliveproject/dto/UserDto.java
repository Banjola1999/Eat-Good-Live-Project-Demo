package com.example.eatgoodliveproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String fullName;
    private String username;
    private String password;
    private String countryCode;
    private Long phoneNumber;
    private String profilePictureUrl;


}
