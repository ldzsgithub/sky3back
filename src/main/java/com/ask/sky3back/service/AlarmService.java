package com.ask.sky3back.service;

import com.ask.sky3back.bean.Probe;

import java.util.List;

public interface AlarmService {

    List<Probe> selectByHostId(int HostId);
}
