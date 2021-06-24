package com.caching.system.controller;

import com.caching.system.Cache;
import com.caching.system.CacheFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private CacheFactory<String, String> cacheFactory;
    private Cache<String, String> cache;

    CacheController(){
        this.cacheFactory = new CacheFactory<>();
        this.cache = cacheFactory.defaultCache(5);
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key){
        return cache.get(key);
    }

    @GetMapping("/set/{key}/{value}")
    public String set(@PathVariable String key, @PathVariable String value){
        cache.put(key, value);
        return "success";
    }
}
