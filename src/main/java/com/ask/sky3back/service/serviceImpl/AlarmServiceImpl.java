package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.Probe;
import com.ask.sky3back.mapper.AlarmMapper;
import com.ask.sky3back.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmMapper alarmMapper;

    public List<Probe> selectByHostId(int hostId) {
        List<Probe> list = alarmMapper.selectByHostId(hostId);
        return list;
    }
}
