package com.ask.sky3back.common.aop;

import com.ask.sky3back.controller.BaseController;
import com.ask.sky3back.controller.GlobalExceptionHandler;
import com.ask.sky3back.common.util.validate.ValidateKit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ValidateAspect {

    @Autowired
    GlobalExceptionHandler globalExceptionHandler;
    @Autowired
    BaseController baseController;

    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..)))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object validateAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        String msg = (String) ValidateKit.validate(joinPoint);
        System.out.println(msg);
        if(msg != null) {
            return baseController.sss(msg);
        }
        return joinPoint.proceed();
    }
}
