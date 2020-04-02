package com.example.demo.Common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerDefinedException extends RuntimeException{

    private Integer code;

    public CustomerDefinedException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CustomerDefinedException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
