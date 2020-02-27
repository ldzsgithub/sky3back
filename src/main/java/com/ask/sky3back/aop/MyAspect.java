package com.ask.sky3back.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..)))")
    private void pointcut() {
        System.out.println("----myaspect");
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("----before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("----after");
    }

    @AfterReturning("pointcut()")
    public void AfterReturning() {
        System.out.println("----afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void AfterThrowing() {
        System.out.println("----AfterThrowing");
    }
}
