package com.example.demo.Controller;

import com.example.demo.Common.Result;
import com.example.demo.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(path = "/api")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(path = "/redis")
    @ResponseBody
    public Result findUser(@RequestBody Map paramap) {
        Map<String,Object> map = redisService.getRedisData();
        return Result.ok().data(map);
    }

}
