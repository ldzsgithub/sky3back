package com.ask.sky3back.bean;

import lombok.Data;

import java.util.Set;

@Data
public class Department {

    Integer departmentId;
    String departmentName;

    Set<Host> hosts;

}
