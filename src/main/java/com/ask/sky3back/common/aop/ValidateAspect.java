package com.ask.sky3back.common.aop;

import com.ask.sky3back.common.util.validate.ValidateKit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ValidateAspect {

    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..)))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        return ValidateKit.validate(joinPoint);
    }

}
