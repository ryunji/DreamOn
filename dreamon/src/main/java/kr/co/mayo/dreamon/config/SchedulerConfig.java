package kr.co.mayo.dreamon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//참고 블로그 : https://covenant.tistory.com/254
@Configuration
public class SchedulerConfig implements SchedulingConfigurer {
 
    @Value("${thread.pool.size}")
    private int POOL_SIZE;
 
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
 
        scheduler.setPoolSize(POOL_SIZE);
        scheduler.setThreadNamePrefix("Scheduler Thread 실행");
        scheduler.initialize();
 
        taskRegistrar.setTaskScheduler(scheduler);
    }
}
