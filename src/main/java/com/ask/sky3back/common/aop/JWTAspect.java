package com.ask.sky3back.common.aop;

import com.ask.sky3back.common.base.GlobalExceptionHandler;
import com.ask.sky3back.common.util.JWT.JWT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class JWTAspect {

    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..))) && !execution(public * com.ask.sky3back.controller.BaseController.login(..)))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object validateAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        if(JWT.verify()) {
            return joinPoint.proceed();
        };
        return GlobalExceptionHandler.baseExceptionHandler("登录状态错误,请重新登录", -1);
    }

}
