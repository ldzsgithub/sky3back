package com.ask.sky3back.service;

import com.ask.sky3back.bean.HistoryRecord;
import com.ask.sky3back.bean.HistoryRecordLine;
import com.ask.sky3back.bean.Probe;

import java.util.List;

public interface AlarmService {

    List<Probe> selectByHostId(int HostId);

    List<HistoryRecord> selectHistoryByProbeId(int probeId, String date);

    int[] selectHistoryByProbeIdLine(int probeId, String date);
}
