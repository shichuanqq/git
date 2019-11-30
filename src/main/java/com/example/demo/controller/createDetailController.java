package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class createDetailController {

    @GetMapping("/test")
    public void test(){
        System.out.println(111);
        System.out.println(111);
    }
}
