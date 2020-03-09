package com.ask.sky3back.common.util.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AuthKit {

    public static Object auth(ProceedingJoinPoint joinPoint) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String a = request.getHeader("aaa");

        System.out.println(a);

        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return o;
    }
}
