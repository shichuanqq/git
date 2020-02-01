package com.example.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisTest {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void test() {

        ListOperations<String, String> ops = redisTemplate.opsForList();
        Long a = ops.leftPush("a", "a");

        log.info("a :{}  ", a);

    }

}
