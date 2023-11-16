package com.example.loverbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.loverbackend.common.CommonResponse;
import com.example.loverbackend.domain.User;
import com.example.loverbackend.mapper.UserMapper;
import com.example.loverbackend.service.UserService;
import com.example.loverbackend.util.CaptchaUtil;
import com.example.loverbackend.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailUtil emailUtil;
    /**
     * 登录
     * @param username 用户名
     * @param password 用户密码
     * @return 返回用户id
     */
    @Override
    public CommonResponse<String> login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, username).eq(User::getPassword, password);
        User user = userMapper.selectOne(queryWrapper);

        String id = user.getId().toString();
        return CommonResponse.creatForSuccessMessageData("登录成功", id);
    }


    private static final int OUT_TIME = 5 * 60 * 1000; // 5min
    /**
     * 发送验证码
     * @param email 目标邮箱
     * @return 返回信息
     */
    @Override
    public CommonResponse<String> captcha(String email) {
        // 验证是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername, email);
        User user = userMapper.selectOne(queryWrapper);

        if(user != null) {
            return CommonResponse.creatForErrorMessage("该邮箱已注册，请直接登录");
        }

        // 发邮件
        String code = CaptchaUtil.getCode();
        boolean flag = emailUtil.sendMail(email, code);
        if(!flag) {
            return CommonResponse.creatForFailMessage("注册失败，邮箱验证码发送失败");
        }

        // 存入数据库
        user = new User();
        user.setUsername(email);
        user.setCaptcha(code);
        int result = userMapper.insert(user);
        if(result == 0) {
            return CommonResponse.creatForFailMessage("注册失败，数据库保存失败");
        }

        // 超时删除
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                queryWrapper.lambda().eq(User::getUsername, email).eq(User::getCaptcha, code);
                userMapper.delete(queryWrapper);
                System.out.println("验证码" + code + "超时删除");
            }
        }, OUT_TIME);

        return CommonResponse.creatForSuccessMessage("验证码发送成功");
    }
    /**
     * 注册
     * @param email 邮箱（作为账号）
     * @param password 密码
     * @param captcha 验证码
     * @return 返回信息exit
     *
     */
    @Override
    public CommonResponse<String> register(String email, String password, String captcha) {
        return null;
    }
}
