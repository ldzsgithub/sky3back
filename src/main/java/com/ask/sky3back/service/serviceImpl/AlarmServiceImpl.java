package com.ask.sky3back.service.serviceImpl;

import com.ask.sky3back.bean.HistoryRecord;
import com.ask.sky3back.bean.HistoryRecordLine;
import com.ask.sky3back.bean.Probe;
import com.ask.sky3back.mapper.AlarmMapper;
import com.ask.sky3back.mapper.HistoryMapper;
import com.ask.sky3back.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("alarmService")
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmMapper alarmMapper;
    @Autowired
    private HistoryMapper historyMapper;

    public List<Probe> selectByHostId(int hostId) {
        List<Probe> list = alarmMapper.selectByHostId(hostId);
        return list;
    }

    @Override
    public List<HistoryRecord> selectHistoryByProbeId(int probeId, String date) {
        Probe probe = alarmMapper.selectProbeByProbeId(probeId);
        String columName = "A" + probe.getProbeBh();
        String tableName = date.substring(0, date.length()-2);
        List<HistoryRecord> list = historyMapper.selectHistory(date, columName, tableName, probe.getHostId());
        return list;
    }

    @Override
    public int[] selectHistoryByProbeIdLine(int probeId, String date) {
        Probe probe = alarmMapper.selectProbeByProbeId(probeId);
        String columName = "A" + probe.getProbeBh();
        String tableName = date.substring(0, date.length()-2);
        List<HistoryRecordLine> list = historyMapper.selectHistoryLine(date, columName, tableName, probe.getHostId());
        int[] a = new int[24];
        for(HistoryRecordLine s : list) {
            a[s.getH()] = s.getValue();
        }
        return a;
    }
}
