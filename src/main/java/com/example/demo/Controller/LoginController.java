package com.example.demo.Controller;

import com.example.demo.Common.Result;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String login()
    {
        return "login";
    }

    @PassToken
    @RequestMapping(path = "/login")
    @ResponseBody
    public Result findUser(@RequestBody User user) {
        Map<String,Object> map = userService.getUser(user.getUsername(),user.getPassword());
        return Result.ok().data(map);
    }

}
