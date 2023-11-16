package com.example.loverbackend.controller;

import com.example.loverbackend.common.CommonResponse;
import com.example.loverbackend.domain.User;
import com.example.loverbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public CommonResponse<String> login(@Valid @RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @GetMapping("/captcha")
    public CommonResponse<String> captcha(@Valid @RequestBody User user) {
        return userService.captcha(user.getUsername());
    }

    @PostMapping("/register")
    public CommonResponse<String> register() {
        return null;
    }
}
