package com.example.demo.Common;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ExceptionController implements ErrorController {

    @RequestMapping("/error")
    public Result handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return Result.setResult(ResultEnum.UNEXIST_URL).setCode(statusCode);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
