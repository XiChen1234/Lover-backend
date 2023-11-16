package com.example.loverbackend.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private final int status;
    private final String message;
    private T data;

    public CommonResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private CommonResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }


    /**
     * 创建成功通用返回类
     * @return 成功状态码、默认成功信息
     */
    public static <T> CommonResponse<T> creatForSuccess() {
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc());
    }

    /**
     * 创建成功通用返回类
     * @param message 自定义成功信息
     * @return 成功状态码、自定义成功信息
     */
    public static <T> CommonResponse<T> creatForSuccessMessage(String message) {
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(), message);
    }

    /**
     * 创建成功通用返回类
     * @param data 自定义数据
     * @return 成功状态码、默认成功信息、自定义数据
     */
    public static <T> CommonResponse<T> creatForSuccessData(T data) {
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(), data);
    }

    /**
     * 创建成功通用返回类
     * @param message 自定义成功信息
     * @param data 自定义数据
     * @return 成功状态码、自定义信息、自定义数据
     */
    public static <T> CommonResponse<T> creatForSuccessMessageData(String message, T data) {
        return new CommonResponse<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 创建失败通用返回类
     * @return 失败状态码、默认失败信息
     */
    public static <T> CommonResponse<T> creatForFail() {
        return new CommonResponse<>(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getDesc());
    }

    /**
     * 创建失败通用返回类
     * @param message 自定义失败信息
     * @return 失败状态码、自定义失败信息
     */
    public static <T> CommonResponse<T> creatForFailMessage(String message) {
        return new CommonResponse<>(ResponseCode.FAIL.getCode(), message);
    }

    /**
     * 创建错误通用返回类
     * @return 错误状态码、默认错误信息
     */
    public static <T> CommonResponse<T> creatForError() {
        return new CommonResponse<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    /**
     * 创建错误通用返回类
     * @param message 自定义错误信息
     * @return 错误状态码、自定义错误信息
     */
    public static <T> CommonResponse<T> creatForErrorMessage(String message) {
        return new CommonResponse<>(ResponseCode.ERROR.getCode(), message);
    }


}

//

//
//
//}
