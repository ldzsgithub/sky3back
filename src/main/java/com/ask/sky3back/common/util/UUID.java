package com.ask.sky3back.common.util;

public class UUID {
    public final static String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }
}
