package com.example.loverbackend.util;

import java.util.Random;

public class CaptchaUtil {
    private static final String CODE_POOL = "0123456789abcdefghijklmnopqresuvwxyz";
    private static final int SIZE = 4;

    public static String getCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for(int i=0;i<SIZE;i++) {
            code.append(CODE_POOL.charAt(random.nextInt(CODE_POOL.length())));
        }

        return code.toString();
    }

    public static void main(String[] args) {
        System.out.println(getCode());
    }
}
