package com.example.demo.Controller;

import com.example.demo.Common.Result;
import com.example.demo.Entity.Files;
import com.example.demo.Service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/api/files")
public class FilesController {
    private String prefix = "bootstrap/";

    @Autowired
    private FilesService filesService;

    @GetMapping("/files")
    public String filesmanage()
    {
        return prefix + "filesmanage";
    }

    @RequestMapping(path = "/list")
    @ResponseBody
    public Map findFiles(@RequestBody Files files) {
        List<Files> list = filesService.getFiles();
        Map<String,Object> map = new HashMap<>();
        map.put("code","0");
        map.put("msg","查询成功!");
        map.put("rows",list);
        map.put("total",list.size());
        return map;
    }

}
