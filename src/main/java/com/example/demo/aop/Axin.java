package com.example.demo.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Axin {
    /**
     * 所属模块
     * @return
     */
    String module()  default "日志模块";

    /**
     * 动作描述
     * @return
     */
    String desc()  default "无动作";
}