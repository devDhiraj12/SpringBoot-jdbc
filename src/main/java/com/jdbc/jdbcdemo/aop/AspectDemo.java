package com.jdbc.jdbcdemo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

    @After("execution (* com.jdbc.jdbcdemo.serviceimpl.Carimpl.testAop(..))")
    void executeAopCheck(){
        System.out.println("hello from Aop side");
    }

}
