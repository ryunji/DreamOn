package kr.co.mayo.dreamon.controller.admin.Scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.SchedulerService;
import kr.co.mayo.dreamon.service.admin.news.CrawlingService;

@Controller
@RequestMapping("admin/scheduler")
public class JobController {
    
    @Autowired
    private SchedulerService service;

    @Autowired
    private CrawlingService newsCrawlingService;

    @RequestMapping("list")
    public String list(Model model){

        List<Schedules> list      = newsCrawlingService.getList();
        List<ScheduleLog> logList = service.getLogList();
      
        model.addAttribute("list",    list);
        model.addAttribute("logList", logList);
        return "admin/newsCrawling/list";
    }
}
