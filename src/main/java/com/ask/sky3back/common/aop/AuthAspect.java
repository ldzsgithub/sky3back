package com.ask.sky3back.common.aop;

import com.ask.sky3back.common.util.auth.AuthKit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AuthAspect {

    @Pointcut("@annotation(com.ask.sky3back.common.anno.auth.AuthRole) || @annotation(com.ask.sky3back.common.anno.auth.AuthPermission)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object validateAspect(ProceedingJoinPoint joinPoint) {
        System.out.println("aspect2");
        return AuthKit.auth(joinPoint);
    }

}
