package kr.co.mayo.dreamon.service.admin;

import java.util.List;

import kr.co.mayo.dreamon.entity.ScheduleLog;

public interface SchedulerService {

    //로그 등록
    void registLog(ScheduleLog scheduleLog);
    //2.로그 조회
    List<ScheduleLog> getLogList();    
}
