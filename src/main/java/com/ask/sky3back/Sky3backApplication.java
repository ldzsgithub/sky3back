package com.ask.sky3back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ask.sky3back.mapper")
public class Sky3backApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sky3backApplication.class, args);
    }

}
