package com.example.demo.test;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

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
