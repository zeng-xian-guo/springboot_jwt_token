package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.util.Map;

public interface UserService {

    Map<String,Object> getUser(String username);

    User getUserById(String id);

}
