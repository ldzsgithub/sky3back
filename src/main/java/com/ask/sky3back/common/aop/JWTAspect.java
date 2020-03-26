package com.ask.sky3back.common.aop;

import com.ask.sky3back.common.base.GlobalExceptionHandler;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.common.util.JWT.JWT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
//@Component
@Order(1)
public class JWTAspect {

    /*
    切点表达式，排除指定方法不生效
     && !execution(public * com.ask.sky3back.controller.BaseController.login(..)))
     */
    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..)))")
    public void pointcut(){}

    @Around("pointcut()")
    public Object validateAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(method.getName() != null && (method.getName().equals("login") || method.getName().equals("register"))) {
            return joinPoint.proceed();
        };
        if(JWT.verify()) {
            return joinPoint.proceed();
        };
        return GlobalExceptionHandler.baseExceptionHandler(ResultStatus.JWT_LOST);
    }

}
