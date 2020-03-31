package com.example.demo.Controller;

import com.example.demo.annotation.UserLoginToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/api")
public class IndexController {

    private String prefix = "index/";

    @GetMapping("/index")
    public String index()
    {
        return prefix + "index";
    }

    @UserLoginToken
    @PostMapping("/test")
    @ResponseBody
    public Object test(){
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("message","你已通过验证了");
        return map;
    }
}
