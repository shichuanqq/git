package com.example.demo.executors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时执行job
 */
@Slf4j
@Component
public class ScheduledThreadPool {

    private LinkedBlockingDeque<String> message = new LinkedBlockingDeque<>();

    private static ScheduledExecutorService scheduledExecutorService =
            new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setNameFormat("msg-process-%d").build());

    private static final Integer BATH_SIZE = 1000;

    public void setMessage(String msg){
        message.push(msg);
    }

    private List<String> getBathMessage() {
        List<String> messageList = Lists.newArrayList();
        int loopCount;

        if (message.size() > BATH_SIZE) {
            loopCount = BATH_SIZE;
        } else {
            loopCount = message.size();
        }
        for (int i = 0; i < loopCount; i++) {
            try {
                messageList.add(message.take());
            } catch (Exception e) {
                break;
            }
        }
        return messageList;
    }

    @PostConstruct
    private void initTask() {
        log.info("start init Task");
        scheduledExecutorService.scheduleWithFixedDelay(
                () -> {
                    List<String> bathMessage = this.getBathMessage();
                    bathMessage.forEach(System.out::println);
                }, 5, 5, TimeUnit.SECONDS
        );
    }

}
