package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api")
public class BootStrapController {

    private String prefix = "bootstrap/";

    @GetMapping("/table")
    public String bootstraptable()
    {
        return prefix + "bootstraptable";
    }

}
