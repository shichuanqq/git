package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AxinAspect {

    /**
     * 这里定义了一个总的匹配规则，以后拦截的时候直接拦截log()方法即可，无须去重复写execution表达式
     */
    @Pointcut("@annotation(Axin)")
    public void log() {
    }

    @Before("log()&&@annotation(axin)")
    public void doBefore(JoinPoint joinPoint, Axin axin) {
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i + 1) + "个参数为:" + args[i]);
        }
    }

    @After("log()")
    public void doAfter() {
        System.out.println("******拦截后的逻辑******");
    }
}