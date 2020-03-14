package com.ask.sky3back.common.util.JWT;

import com.ask.sky3back.common.util.MD5;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class JWT {

    public static String creat(String user) {
        return MD5.getmd5(user);
    }

    public static boolean verify() {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String JWT = request.getHeader("JWT");
        String user = request.getHeader("user");
        if(JWT != null && user != null) {
            return JWT.equals(MD5.getmd5(user));
        }
        return false;
    }

}
