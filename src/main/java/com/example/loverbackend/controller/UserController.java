package com.example.loverbackend.controller;

import com.example.loverbackend.common.CommonResponse;
import com.example.loverbackend.domain.User;
import com.example.loverbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResponse<String> login(@Valid @RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/captcha")
    public CommonResponse<String> captcha(String email) {
        return null;
    }

    @PostMapping("/register")
    public CommonResponse<String> register() {
        return null;
    }
}
