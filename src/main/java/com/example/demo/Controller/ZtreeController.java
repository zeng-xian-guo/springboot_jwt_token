package com.example.demo.Controller;

import com.example.demo.Common.Result;
import com.example.demo.Entity.Dept;
import com.example.demo.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class ZtreeController {

    private String prefix = "home/";

    @Autowired
    private DeptService deptService;

    @GetMapping("/ztree")
    public String ztree()
    {
        return prefix + "ztree";
    }

    @RequestMapping("/tree")
    @ResponseBody
    public Result getTreeData(){
        System.out.println("我被加载了!!!");
        List<Dept> depyList = deptService.queryTreeSimpleData();
        return Result.ok().data("list",depyList);
    }

}
