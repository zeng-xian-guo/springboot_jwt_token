package com.example.demo.Common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)
@Data
public class Result {
    // 响应码
    private Integer code;

    // 响应消息
    private String message;

    // 响应数据
    private Map<String, Object> data = new HashMap<>();

    // 私有构造器
    private Result() {

    }

    // 通用成功
    public static Result ok() {
        return new Result()
                .setCode(ResultEnum.SUCCESS.getCode())
                .setMessage(ResultEnum.SUCCESS.getMessage());
    }

    public static Result ok(String message) {
        return new Result()
                .setCode(ResultEnum.SUCCESS.getCode())
                .setMessage(message);
    }

    // 通用失败
    public static Result error() {
        return new Result()
                .setCode(ResultEnum.UNKNOWN_ERROR.getCode())
                .setMessage(ResultEnum.UNKNOWN_ERROR.getMessage());
    }

    public static Result error(Integer code,String message) {
        return new Result()
                .setCode(code)
                .setMessage(message);
    }

    // 自定义返回信息
    public static Result setResult(ResultEnum result) {
        return new Result()
                .setCode(result.getCode())
                .setMessage(result.getMessage());
    }

    /** ------------使用链式编程，返回类本身-----------**/
    // 自定义返回数据
    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }

    // 通用设置data
    public Result data(String key,Object value) {
        this.data.put(key, value);
        return this;
    }

    // 自定义状态信息
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

}
