package kr.co.mayo.dreamon.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.ScheduleLog;

@Mapper
public interface SchedulerRepository {
    
    void registLog(ScheduleLog scheduleLog);    
    List<ScheduleLog> findAllLog();
}
