package com.example.demo;

import com.example.demo.rabbitmq.direct.DirectSender;
import com.example.demo.rabbitmq.fanout.FanoutSender;
import com.example.demo.rabbitmq.topic.TopicSender;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
//public class DemoApplicationTests {
//
//    @Autowired
//    private DirectSender sender;
//
//    @Autowired
//    private TopicSender topicSender;
//
//    @Autowired
//    private FanoutSender fanoutSender;
//
//    @Test
//    public void send1(){
//        fanoutSender.send("qwertttt");
//    }
//
//    @Test
//    public void send(){
//        topicSender.send("11111111111");
//    }
//
//    @Test
//    public void contextLoads() {
//        sender.send("123131313");
//    }
//
//}
