package com.ask.sky3back.common.util.auth;

import com.ask.sky3back.bean.User;
import com.ask.sky3back.common.anno.auth.AuthPermission;
import com.ask.sky3back.common.anno.auth.AuthRole;
import com.ask.sky3back.common.base.GlobalExceptionHandler;
import com.ask.sky3back.common.base.ResultStatus;
import com.ask.sky3back.service.serviceImpl.UserServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

public class AuthKit {

    @Autowired
    private static UserServiceImpl userService;

    public static Object auth(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(method == null) {
            return null;
        }
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String username = request.getHeader("user");

        User user = userService.selectUserByUsername(username);
        if(method.getAnnotation(AuthRole.class) != null) {
            if(user.getRole() < method.getAnnotation(AuthRole.class).level()) {
                return GlobalExceptionHandler.baseExceptionHandler(ResultStatus.AUTH_ROLE.getMsg(), ResultStatus.AUTH_ROLE.getCode());
            };
        }
        if(method.getAnnotation(AuthPermission.class) != null) {
            user.setAuth(user.getAuthority().split(","));
            request.setAttribute("auth",user.getAuth());
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
