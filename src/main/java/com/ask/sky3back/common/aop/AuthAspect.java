package com.ask.sky3back.common.aop;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.auth.AuthPermission;
import com.ask.sky3back.common.anno.auth.AuthRole;
import com.ask.sky3back.common.base.GlobalExceptionHandler;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.common.util.MD5;
import com.ask.sky3back.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Order(3)
public class AuthAspect {
    @Autowired
    UserService userService;

    @Pointcut("@annotation(com.ask.sky3back.common.anno.auth.AuthRole) || @annotation(com.ask.sky3back.common.anno.auth.AuthPermission)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object validateAspect(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(method == null) return null;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String username = MD5.unicodeToString(request.getHeader("user"));
        request.setAttribute("username", username);
        User user = userService.selectUserByUsername(username);
        if(method.getAnnotation(AuthRole.class) != null) {
            if(user.getLoginflag() < method.getAnnotation(AuthRole.class).level()) {
                return GlobalExceptionHandler.baseExceptionHandler(ResultStatus.AUTH_ROLE.getMsg(), ResultStatus.AUTH_ROLE.getCode());
            };
        }
        if(method.getAnnotation(AuthPermission.class) != null) {
            request.setAttribute("auth", user.getAuthority().split(","));
        }

        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return o;
    }

}
