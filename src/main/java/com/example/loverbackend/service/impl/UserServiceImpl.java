package com.example.loverbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loverbackend.common.CommonResponse;
import com.example.loverbackend.domain.User;
import com.example.loverbackend.mapper.UserMapper;
import com.example.loverbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public CommonResponse<String> login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username).eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);

        String id = user.getId().toString();
        return CommonResponse.creatForSuccessMessageData("登录成功", id);
    }

    @Override
    public CommonResponse<String> captcha(String email) {
        return null;
    }

    @Override
    public CommonResponse<String> register(String email, String password, String captcha) {
        return null;
    }
}
