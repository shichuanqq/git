package com.example.demo.entity;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class InventoryDetailDTO{

    private String id;

    private String code;

    private String name;
}
