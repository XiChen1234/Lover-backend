package com.example.loverbackend.service;

import com.example.loverbackend.common.CommonResponse;

public interface UserService {
    /**
     * 登录
     * @param username 用户名
     * @param password 用户密码
     * @return 返回用户id
     */
    public CommonResponse<String> login(String username, String password);

    /**
     * 发送验证码
     * @param email 目标邮箱
     * @return 返回信息
     */
    public CommonResponse<String> captcha(String email);

    /**
     * 注册
     * @param email 邮箱（作为账号）
     * @param password 密码
     * @param captcha 验证码
     * @return 返回信息
     */
    public CommonResponse<String> register(String email, String password, String captcha);
}
