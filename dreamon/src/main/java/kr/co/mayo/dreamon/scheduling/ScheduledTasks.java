package kr.co.mayo.dreamon.scheduling;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.co.mayo.dreamon.controller.CrawlingController;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;
import lombok.extern.slf4j.Slf4j;

//참고 블로그 : https://covenant.tistory.com/254
@Slf4j     // 로그를 위해서
@Component // 빈 등록 
public class ScheduledTasks {
 
    @Autowired
    private NewsCrawlingService newsCrawlingService;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");    //DateTimeFormatter.ofPattern("mm:ss:SSS");

  //@Scheduled(fixedRate = 3000)
  //@Scheduled(cron = "0 0 7 * * ?")
    @Scheduled(cron = "0 * * * * *")
  //public void fixedRate() {
    public void cronExpression(){    
        
        List<Schedules> list = newsCrawlingService.getList();
        for(Schedules schedule : list) {
            
            String url = schedule.getUrl();
            System.out.println("url : " + url);
            try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                // 성공
                System.out.println("URL 호출 성공!");
            } else {
                // 실패
                System.out.println("URL 호출 실패! 응답 코드: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

            log.info("Cron Scheduler 실행 시간 - {}", formatter.format(LocalDateTime.now()));
        }
    }
}