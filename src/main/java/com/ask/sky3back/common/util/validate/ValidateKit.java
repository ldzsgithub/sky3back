package com.ask.sky3back.common.util.validate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ValidateKit {

    public static Object validate(ProceedingJoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(method == null || method.getAnnotation(RequestMapping.class) == null) {
            System.out.println("RequestMapping.class == null");
            return null;
        }
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();
        for(int i = 0, length = args.length; i < length; i++){
            Annotation[] annotations = parameters[i].getAnnotations();
            for(Annotation annotation : annotations){
                ValidateCheck.check(annotation, args[i]);
                System.out.println(annotation);
            }
        }
        System.out.println("111");
        return null;
    }
}
