package com.example.loverbackend.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@TableName("user")
public class User {
    @TableId
    private Integer id;
    @Email(message = "邮箱格式不正确")
    private String username;
    @Length(min = 6, max = 20, message = "密码格式不正确")
    private String password;
    @Length(min = 4, max = 4, message = "验证码格式不正确")
    private String captcha;
}
