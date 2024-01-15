package com.example.eatgoodliveproject.controller;

import com.example.eatgoodliveproject.dto.LoginDto;
import com.example.eatgoodliveproject.dto.SignupDto;
import com.example.eatgoodliveproject.dto.UserDto;
import com.example.eatgoodliveproject.model.Users;
import com.example.eatgoodliveproject.service.UserService;
import com.example.eatgoodliveproject.serviceimpl.UserServiceImpl;
import com.example.eatgoodliveproject.utils.GoogleJwtUtils;
import com.example.eatgoodliveproject.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class AuthController {

    private UserServiceImpl userService;
    private JwtUtils jwtUtils;
    private GoogleJwtUtils googleJwtUtils;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthController(UserServiceImpl userService, JwtUtils jwtUtils, GoogleJwtUtils googleJwtUtils, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtils = jwtUtils;
        this.googleJwtUtils = googleJwtUtils;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/google/{tkn}")
    public ResponseEntity<String> authorizeOauthUser(@PathVariable("tkn") String token){
        return ResponseEntity.ok(googleJwtUtils.googleOauthUserJWT(token));

    }


    @GetMapping("/dashboard")
    public String index(){
        return "Welcome to your account";
    }
    @PostMapping("/customer-sign-up")
    public ResponseEntity<SignupDto> signUpCustomer(@RequestBody SignupDto signupDto){
        Users user = userService.saveUser.apply(signupDto);
        SignupDto signupDto1 = new ObjectMapper().convertValue(user, SignupDto.class);
        return new ResponseEntity<>(signupDto1, HttpStatus.OK);
    }

    @PostMapping("/vendor-sign-up")
    public ResponseEntity<SignupDto> signUpVendor(@RequestBody SignupDto signupDto){
        Users user = userService.saveAdmin(signupDto);
        SignupDto signupDto1 = new ObjectMapper().convertValue(user, SignupDto.class);
        return new ResponseEntity<>(signupDto1, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto userDto){
        UserDetails user = userService.loadUserByUsername(userDto.getUsername());
        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())){
            String token = jwtUtils.createJwt.apply(user);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Username or Password not correct!",
                HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAccount(@AuthenticationPrincipal Users currentUser) {
        userService.removeUser(currentUser.getId());
        return ResponseEntity.ok().build();
    }

}
