package com.ask.sky3back.common.anno.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface MinSize {
    String msg() default "长度太短";
    int code() default -1;
    int length();
}
