package com.example.demo.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAnn")
@Aspect
public class LogAspectAnnotation {

    @Before("execution(* com.example.demo.controller.*.*(..))")
    public void bBefore() {
        System.out.println("@@@前置通知");
    }
    @AfterReturning("execution(* com.example.demo.controller.*.*(..)))")
    public void bAfter() {
        System.out.println("@@@后置通知");
    }
    @AfterThrowing("execution(* com.example.demo.controller.*.*(..)))")
    public void bThrowing() {
        System.out.println("@@@异常通知");
    }
}
