package com.example.demo.Controller;

import com.example.demo.Entity.Cache;
import com.example.demo.Service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/{id}")
    @ResponseBody
    public Cache cache(@PathVariable(value = "id") String id){
        return cacheService.cache(id);
    }

    @GetMapping("/user")
    @ResponseBody
    public List<Cache> cacheList(){
        return cacheService.list();
    }

    @GetMapping("/delete")
    @ResponseBody
    public void deleteWorkInfo() {
        cacheService.deleteCacheUser();
    }
}
