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

@RestController
@RequestMapping("/alarm")
@CrossOrigin
public class AlarmController {
    @Autowired
    private AlarmService alarmService;

    /**
     * 实时数据
     * params HostId 0全部
     */
    @RequestMapping("/selectByHostId")
    public JsonResult selectByHostId(@NotNull int hostId) {
        List<Probe> list = alarmService.selectByHostId(hostId);
        return new JsonResult(list);
    }

    /**
     * 历史数据折线图
     * @param probeId
     * @param date
     * @return 24个int,每小时max值
     */
    @RequestMapping("/selectHistoryByProbeIdLine")
    public JsonResult selectHistoryByProbeIdLine(@NotNull int probeId, @NotNull String date) {
        int[] a = alarmService.selectHistoryByProbeIdLine(probeId, date);
        return new JsonResult(a);
    }

    /**
     * 查询历史数据,列表展示,全查
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
