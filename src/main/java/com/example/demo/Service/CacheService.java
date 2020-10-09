package com.example.demo.Service;

import com.example.demo.Entity.Cache;

import java.util.List;

public interface CacheService {
    Cache  cache(String id);
    List<Cache> list();
    void deleteCacheUser();
}
