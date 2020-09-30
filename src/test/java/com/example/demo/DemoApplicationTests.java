package com.example.demo;

import com.example.demo.rabbitmq.direct.DirectSender;
import com.example.demo.rabbitmq.fanout.FanoutSender;
import com.example.demo.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Autowired
    private DirectSender sender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void send1(){
        fanoutSender.send("qwertttt");
    }

    @Test
    public void send(){
        topicSender.send("11111111111");
    }

    @Test
    public void contextLoads() {
        sender.send("123131313");
    }

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test1(){
        Integer num = 1; //数量
        String CART = "CART"; // key
        String sku = "1234567";
        String userId = "001";
        List<Object> values = redisTemplate.boundHashOps(CART + userId).values();
        values.forEach(System.out::println);
    }

    @Test
    public void redisTest(){
        /**
         * 1）查询redis中的数据
         * 2）如果redis中已经有了，则追加数量，重新计算金额
         * 3）如果没有，将商品添加到缓存
         */
        Integer num = 1; //数量
        String CART = "CART"; // key
        String sku = "1234567";
        String userId = "001";
//        OrderItem values = (OrderItem) redisTemplate.boundHashOps(CART + userId).values();
//
//        //redisTemplate.boundHashOps新增元素到指定键中
//        OrderItem orderItem = (OrderItem) redisTemplate.boundHashOps(CART + userId).get(sku);
//        if (orderItem != null) {
//            //存在，刷新购物车
//            orderItem.setNum(orderItem.getNum() + num);
//            //如果数量<=0，应该移除该商品
//            if (orderItem.getNum()<= 0){
//                redisTemplate.boundHashOps(CART + userId).delete(sku);
//                return;
//            }
//            orderItem.setMoney(orderItem.getNum() * orderItem.getPayMoney());
//            orderItem.setPayMoney(orderItem.getNum() * orderItem.getPayMoney());
//        } else {
//            //不存在，新增购物车
//            orderItem = new OrderItem();
//            orderItem.setNum(num);
//            orderItem.setMoney(5.5);
//            orderItem.setPayMoney(6.6);
//        }
//        //存入redis
//        redisTemplate.boundHashOps(CART + userId).put(sku, orderItem);
    }

}
