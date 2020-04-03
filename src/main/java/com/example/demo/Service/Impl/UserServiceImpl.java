package com.example.demo.Service.Impl;

import com.example.demo.Common.CustomerDefinedException;
import com.example.demo.Common.JwtTokenUtil;
import com.example.demo.Common.ResultEnum;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String,Object> getUser(String username,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        User userinfo = userRepository.findByUsernameAndPassword(username,password);
        if(userinfo != null){
            map.put("list",userinfo);
            String token = JwtTokenUtil.createToken(userinfo.getUsername());
            map.put("token",token);
        }else {
            throw new CustomerDefinedException(ResultEnum.UNEXIST_ERROR);
        }
        return map;
    }

}
