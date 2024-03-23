package kr.co.mayo.dreamon.scheduling;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.co.mayo.dreamon.controller.CrawlingController;
import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;
import kr.co.mayo.dreamon.service.admin.SchedulerService;
import lombok.extern.slf4j.Slf4j;

//참고 블로그 : https://covenant.tistory.com/254
@Slf4j     // 로그를 위해서
@Component // 빈 등록 
public class ScheduledTasks {
 
    // @Autowired
    // private ScheduleLog scheduleLog;
    
    @Autowired
    private SchedulerService service;

    @Autowired
    private NewsCrawlingService newsCrawlingService;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");    //DateTimeFormatter.ofPattern("mm:ss:SSS");

  //@Scheduled(fixedRate = 3000)
  @Scheduled(cron = "0 0 7 * * ?")
    //@Scheduled(cron = "0 * * * * *")
  //public void fixedRate() {
    public void cronExpression(){    
        
        //1.실행할 스케줄러 리스트 조회.
        List<Schedules> list = newsCrawlingService.getList();
        for(Schedules schedule : list) {
            
            String url = schedule.getUrl();
            Long id    = schedule.getId();          //스케쥴 ID : SCHEDULES_ID

            ScheduleLog schLog = new ScheduleLog();
            schLog.setSchedulesId(id);
            
            System.out.println("url : " + url);
            try {
                
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                
                //현재 날짜와 시간으로 Timestamp 객체 생성
                Timestamp executionTime = new Timestamp(System.currentTimeMillis());
                schLog.setExcutionTime(executionTime);
                
                int responseCode = con.getResponseCode();
                if (responseCode == 200) {
                    
                    //성공
                    System.out.println("URL 호출 성공!");
                    schLog.setCode((long) responseCode);
                    schLog.setMessage("URL 호출 성공!");
                    schLog.setStatus("SUCESS");
                    service.registLog(schLog);
                } else {
                    
                    //실패
                    System.out.println("URL 호출 실패! 응답 코드: " + responseCode);
                    schLog.setCode((long)responseCode);
                    schLog.setMessage("URL 호출 실패!");
                    schLog.setStatus("FAIL");
                    service.registLog(schLog);
                }
            } catch (Exception e) {
                
                e.printStackTrace();
            }

            log.info("Cron Scheduler 실행 시간 - {}", formatter.format(LocalDateTime.now()));
        }
    }
}