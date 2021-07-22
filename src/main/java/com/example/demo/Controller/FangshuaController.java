package com.example.demo.Controller;

import com.example.demo.Annotation.AccessLimit;
import com.example.demo.Annotation.UserLoginToken;
import com.example.demo.Common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class FangshuaController {

    @AccessLimit(seconds=120, maxCount=5)
    @PostMapping("/fangshua")
    @ResponseBody
    public Result fangshua(){
        return Result.ok().message("你已通过验证啦!");
    }

}
