package com.example.demo.controller;

import com.example.demo.aop.Axin;
import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.service.CreateDetailService;
import com.example.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class createDetailController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    private CreateDetailService createDetailService;

    /**
     * 测试redis
     */
    @GetMapping("/redisTest")
    public void test(){
        redisUtils.set("a","test");
        System.out.println(redisUtils.get("a"));
    }

    /**
     * 切换数据源
     * @return
     */
    @GetMapping("/db1")
    public List<InventoryDetailDTO> test1(){
        return createDetailService.queryDetail();
    }

    @GetMapping("/db2")
    public List<InventoryDetailDTO> test2(){
        return createDetailService.queryDetail1();
    }

    @Axin(module = "print",desc = "打印")
    @GetMapping("/controller")
    public InventoryDetailDTO getDetail(String code,String name){
        InventoryDetailDTO inventoryDetailDTO = new InventoryDetailDTO();
        inventoryDetailDTO.setCode("code");
        inventoryDetailDTO.setName("name");
        return inventoryDetailDTO;
    }
}
