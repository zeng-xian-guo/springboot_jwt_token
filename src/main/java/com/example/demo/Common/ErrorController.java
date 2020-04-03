package com.example.demo.Common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    //针对浏览器端error异常处理--跳转403、404、500、error页面
    @RequestMapping(value = "/error", produces = "text/html")
    public String errorPageHandler(HttpServletResponse response) {
        int status = response.getStatus();
        switch (status) {
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "error";
    }

    //针对非浏览器端error异常处理(Postman,APP)--统一返回JSON结果
    @RequestMapping("/error")
    @ResponseBody
    public Result handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        return Result.setResult(ResultEnum.UNEXIST_URL).setCode(statusCode);
    }

}
