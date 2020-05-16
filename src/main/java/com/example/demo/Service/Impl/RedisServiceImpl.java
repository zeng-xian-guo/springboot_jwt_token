package com.example.demo.Service.Impl;

import com.example.demo.Redis.RedisClient;
import com.example.demo.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisClient redisClient;

    @Override
    public Map<String,Object> getRedisData(){
        Map<String,Object> map = new HashMap<>();
        if (redisClient.exists("key_test")){
            map.put("1",redisClient.get("key_test"));
            System.out.println("从redis获取数据!!!");
        }else {
            map.put("1","1");
            redisClient.set("key_test",map);
            System.out.println("从数据库获取数据!!!");
        }
        return map;
    }

}
