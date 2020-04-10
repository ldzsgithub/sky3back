package com.ask.sky3back.mapper;

import com.ask.sky3back.bean.Probe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("alarmMapper")
public interface AlarmMapper {
    List<Probe> selectByHostId(int hostId);

    Probe selectProbeByProbeId(int probeId);
}
