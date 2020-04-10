package com.ask.sky3back.controller;

import com.ask.sky3back.bean.HistoryRecord;
import com.ask.sky3back.bean.Probe;
import com.ask.sky3back.common.anno.validate.NotNull;
import com.ask.sky3back.common.base.JsonResult;
import com.ask.sky3back.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alarm")
@CrossOrigin
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    /*
    * 实时数据
    * params HostId 0全部
    * */
    @RequestMapping("/selectByHostId")
    public JsonResult selectByHostId(@NotNull int hostId) {
        List<Probe> list = alarmService.selectByHostId(hostId);
        return new JsonResult(list);
    }

    /**
     * 查询历史数据
     * @param probeId
     * @param date
     * @return
     */
    @RequestMapping("/selectHistoryByProbeId")
    public JsonResult selectHistoryByProbeId(@NotNull int probeId, @NotNull String date) {
        List<HistoryRecord> list = alarmService.selectHistoryByProbeId(probeId, date);
        return new JsonResult(list);
    }

}
