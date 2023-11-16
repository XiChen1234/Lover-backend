package com.example.loverbackend.common;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),    // 请求成功
    ERROR(400, "ERROR"),        // 请求错误，一般为资源请求方式错误
    FAIL(500, "FAIL");          // 请求失败，一般为服务器内部错误，更严重

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
