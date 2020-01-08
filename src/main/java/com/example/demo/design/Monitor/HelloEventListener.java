package com.example.demo.design.Monitor;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.Demo;
import com.example.demo.entity.InventoryDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloEventListener {

    @EventListener(classes = InventoryDetailDTO.class)
    public void onApplicationEvent(InventoryDetailDTO inventoryDetailDTO) {
        log.info("inventoryDetailDTO {} say hello!", JSONArray.toJSONString(inventoryDetailDTO));
    }

    @EventListener(classes = Demo.class)
    public void onApplicationEvent(Demo demo) {
        log.info("demo {} say hello!", JSONArray.toJSONString(demo));
    }
}
