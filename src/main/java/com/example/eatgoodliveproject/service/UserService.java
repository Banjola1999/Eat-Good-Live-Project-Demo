package com.example.eatgoodliveproject.service;

import com.example.eatgoodliveproject.dto.SignupDto;
import com.example.eatgoodliveproject.model.Users;

import java.util.function.Function;

public interface UserService {
    Users saveAdmin(SignupDto user);
}
