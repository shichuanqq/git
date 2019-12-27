package com.example.demo.controller;

import com.example.demo.aop.Axin;
import com.example.demo.entity.InventoryDetailDTO;
import com.example.demo.executors.ScheduledThreadPool;
import com.example.demo.executors.ThreadQueueUtils;
import com.example.demo.rabbitmq.direct.DirectSender;
import com.example.demo.service.CreateDetailService;
import com.example.demo.utils.EmailUtils;
import com.example.demo.utils.RedisUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

@RestController
public class createDetailController {

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    private CreateDetailService createDetailService;

    @Autowired
    private EmailUtils emailUtils;

    /**
     * 测试redis
     */
    @GetMapping("/redisTest")
    public void test() {
        redisUtils.set("a", "test");
        System.out.println(redisUtils.get("a"));
    }

    /**
     * 切换数据源
     *
     * @return
     */
    @GetMapping("/db1")
    public List<InventoryDetailDTO> test1() {
        return createDetailService.queryDetail();
    }

    @GetMapping("/db2")
    public List<InventoryDetailDTO> test2() {
        return createDetailService.queryDetail1();
    }

    @Axin(module = "print", desc = "打印")
    @GetMapping("/controller")
    public InventoryDetailDTO getDetail(String code, String name) {
        InventoryDetailDTO inventoryDetailDTO = new InventoryDetailDTO();
        inventoryDetailDTO.setCode("code");
        inventoryDetailDTO.setName("name");
        return inventoryDetailDTO;
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("emil")
    public String sendEmail() {
        emailUtils.sendHtmlEmail("111", "75847834@qq.com");
        return "success";
    }

    @Autowired
    private DirectSender directSender;

    @GetMapping("rabbitmq")
    public String send(String msg) {
        directSender.send("test");
        return "success";
    }

    @Autowired
    private ScheduledThreadPool scheduledThreadPool;

    @GetMapping("scheduledThreadPool")
    public String ScheduledThreadPool(String msg) {
        scheduledThreadPool.setMessage(msg);
        return "success";
    }

    @GetMapping("logDebug")
    public String logDebug(){
        return createDetailService.logDebug();
    }

    private Function<String, String> function = new Function<String, String>() {
        @Override
        public String apply(String str) {
            return "6";
        }
    };

    @GetMapping("poolUtils")
    public String poolUtils(String msg) {
        List<String> list = Lists.newArrayList("6");
        ThreadQueueUtils.create(list, function).start(2);
        return "success";
    }
}
