package com.example.lab5.controller;

import com.example.lab5.domain.User;
import com.example.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {
        if(userService.existsByUserName(user.getUserName())){
            return new ResponseEntity<String>("User with such username exists!", HttpStatus.BAD_REQUEST);
        }
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user1);
        return ResponseEntity.ok("User was created!");
    }
}
