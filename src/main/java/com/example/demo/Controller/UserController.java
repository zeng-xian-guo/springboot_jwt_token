package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.annotation.PassToken;
import com.example.demo.annotation.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PassToken
    @RequestMapping(path = "/login")
    @ResponseBody
    public Object findUser(@RequestBody User user) {
        return userService.getUser(user.getUsername());
    }

    @UserLoginToken
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "你已通过验证";
    }

    @RequestMapping(path = "/zxg")
    @ResponseBody
    public User findUserById(@RequestParam(value="id",required=true) String id){
        return userService.getUserById(id);
    }

}
