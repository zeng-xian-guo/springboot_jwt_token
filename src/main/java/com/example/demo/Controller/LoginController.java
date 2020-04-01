package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object findUser(@RequestBody User user) {

        return userService.getUser(user.getUsername(),user.getPassword());
    }

}
