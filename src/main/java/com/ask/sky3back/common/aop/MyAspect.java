package com.ask.sky3back.common.aop;

import com.ask.sky3back.common.anno.MyAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Aspect
@Component
@Order(2)
public class MyAspect {

    @Pointcut("execution(public * com.ask.sky3back.controller.*.*(..)))")
    private void pointcut() {
        System.out.println("----myaspect");
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        Object[] params=joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        for(int i=0;i<parameters.length;i++) {
            Parameter p = parameters[i];
            // 获取参数上的注解
            Validated validated = p.getAnnotation(Validated.class);
            if(p.isAnnotationPresent(MyAnno.class)) {
                System.out.println("12312312312");
                System.out.println(p.getAnnotations().toString());
            };
            if(validated==null) {
                continue;
            }
            // 如果设置了group
//            if(validated.value()!=null && validated.value().length>0) {
//                validator.validate(params[i],null,validated.value());
//            } else {
//                validator.validate(params[i],null);
//            }
        }
        System.out.println("----before000000000000000000000000");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("----after");
    }

    @AfterReturning("pointcut()")
    public void AfterReturning() {
        System.out.println("----afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void AfterThrowing() {
        System.out.println("----AfterThrowing");
    }
}
