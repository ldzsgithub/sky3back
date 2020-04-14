package com.ask.sky3back.mapper;

import com.ask.sky3back.bean.HistoryRecord;
import com.ask.sky3back.bean.HistoryRecordLine;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("historyMapper")
public interface HistoryMapper {

    List<HistoryRecord> selectHistory(String date, String columName, String tableName, Integer hostId);

    List<HistoryRecordLine> selectHistoryLine(String date, String columName, String tableName, Integer hostId);
}
