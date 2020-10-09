package com.example.demo.Service.Impl;

import com.example.demo.Entity.Cache;
import com.example.demo.Repository.CacheRepository;
import com.example.demo.Service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    private CacheRepository cacheRepository;

    @Override
    //@Cacheable(cacheNames = "cache",key = "#id")
    @Cacheable(value = {"cache"},key = "#id")
    public Cache cache(String id) {
        System.out.println("我从数据中查询了！！！！");
        Cache cache = new Cache(id,"zxg","2594523286@qq.com");
        return cache;
    }

    @Override
    @Cacheable(value = "user")
    public List<Cache> list() {
        System.out.println("MySQL查询啦！！！！。。。。");
        return cacheRepository.findAll();
    }

    @Override
    @CacheEvict(value = "user")
    public void deleteCacheUser() {
    }
}
