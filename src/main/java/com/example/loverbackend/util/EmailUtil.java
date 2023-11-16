package com.example.loverbackend.util;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Arrays;
import java.util.Date;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender sender;

    @Resource
    private TemplateEngine engine;

    private static final String USERNAME = "xichen.public@foxmail.com";

    public boolean sendMail(String to, String captcha) {
        // 上下文对象
        Context context = new Context();
        context.setVariable("captcha", Arrays.asList(captcha.split(""))); // 分割
        String process = engine.process("email.html", context);
        MimeMessage message = sender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("【朝暮清晨官方】验证码");
            helper.setFrom(USERNAME);
            helper.setTo(to);
            helper.setSentDate(new Date());
            helper.setText(process, true); // 第二个参数为true表示消息内容类型为HTML
            sender.send(message);

            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
