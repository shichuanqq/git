package com.example.demo.controller;

import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class createDetailController {

    @Autowired
    RedisUtils redisUtils;

    @GetMapping("/test")
    public void test(){
        redisUtils.set("a","test");
        System.out.println(redisUtils.get("a"));
    }
}
