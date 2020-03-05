package com.ask.sky3back.common.util.validate;

import com.ask.sky3back.common.anno.validate.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateKit {

    public static Object validate(ProceedingJoinPoint joinPoint) throws Exception{
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if(method == null || method.getAnnotation(RequestMapping.class) == null) {
            return null;
        }
        Parameter[] parameters = method.getParameters();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Annotation[] annotations = parameters[i].getAnnotations();
            for (Annotation annotation : annotations) {
                String msg = check(annotation, args[i]);
                System.out.println(msg + "***********************");
                if(msg!=null) {
                    return msg;
                }
            }
        }
        return null;
    }

    public static String check(Annotation annotation, Object arg) {
        if(annotation.annotationType() == NotNull.class) {
            if(isNull(arg)) {
                return ((NotNull)annotation).msg();
            }
        }
        if(annotation.annotationType() == NotEmpty.class) {
            if(isEmpty(arg)) {
                return ((NotEmpty)annotation).msg();
            }
        }
        if(annotation.annotationType() == RE.class) {
            if(re(arg, ((RE) annotation).re())){
                return ((RE)annotation).msg();
            }
        }
        if(annotation.annotationType() == MaxSize.class) {
            if(maxSize(arg, ((MaxSize)annotation).length())){
                return ((MaxSize)annotation).msg();
            }
        }
        if(annotation.annotationType() == MinSize.class) {
            if(minSize(arg, ((MinSize)annotation).length())){
                return ((MinSize)annotation).msg();
            }
        }
        if(annotation.annotationType() == Size.class) {
            if(size(arg, ((Size)annotation).length())){
                return ((Size)annotation).msg();
            }
        }
        return null;
    }

    private static boolean size(Object arg, int length) {
        if (isNull(arg)) return true;
        if (String.valueOf(arg).length() > length) {
            return true;
        }
        return false;
    }

    private static boolean minSize(Object arg, int length) {
        if (isNull(arg)) return true;
        if (String.valueOf(arg).length() < length) {
            return true;
        }
        return false;
    }

    private static boolean maxSize(Object arg, int length) {
        if (isNull(arg)) return true;
        if (String.valueOf(arg).length() > length) {
            return true;
        }
        return false;
    }

    private static boolean re(Object arg, String re) {
        if (isNull(arg)) return true;
        Pattern r = Pattern.compile(re);
        Matcher m = r.matcher(String.valueOf(arg));
        if (!m.matches()) {
            return true;
        }
        return false;
    }

    private static boolean isEmpty(Object object) {
        if (isNull(object)) return true;
        if (object instanceof String) {
            if (object.equals("")) {
                return true;
            }
        }
        if (object instanceof Object[]) {
            if (((Object[]) object).length == 0) {
                return true;
            }
        }
        if (object instanceof Iterable) {
            if (!((Iterable) object).iterator().hasNext()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNull(Object arg) {
        return arg == null;
    }
}
