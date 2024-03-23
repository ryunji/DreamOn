package kr.co.mayo.dreamon.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.repository.SchedulerRepository;
import kr.co.mayo.dreamon.service.admin.SchedulerService;

@Service
public class SchedulerServiceImpl implements SchedulerService{

    @Autowired
    private SchedulerRepository repository; 

    @Override
    public void registLog(ScheduleLog scheduleLog) {
        
        repository.registLog(scheduleLog);
    }

    @Override
    public List<ScheduleLog> getLogList() {
        
        List<ScheduleLog> list = repository.findAllLog();
        return list;
    }
}
