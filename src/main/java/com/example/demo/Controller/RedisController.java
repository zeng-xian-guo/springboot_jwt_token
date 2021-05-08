package com.example.demo.Controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Common.Result;
import com.example.demo.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(path = "/redis")
    @ResponseBody
    public Result findUser(@RequestBody JSONObject jsonObject) {
        return redisService.getRedisData();
    }

}
