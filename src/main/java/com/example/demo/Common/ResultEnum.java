package com.example.demo.Common;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(200,"成功"),
    UNEXIST_ERROR(404,"用户不存在或密码有误"),
    UNKNOWN_ERROR(520,"未知错误"),
    SYSTEM_ERROR(500, "系统异常"),
    PARAM_ERROR(201,"参数错误"),
    NULL_POINTER(202,"空指针异常");

    // 响应状态码
    private Integer code;
    // 响应信息
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
