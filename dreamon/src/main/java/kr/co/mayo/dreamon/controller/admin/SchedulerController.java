package kr.co.mayo.dreamon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;
import kr.co.mayo.dreamon.service.admin.SchedulerService;

@Controller
@RequestMapping("admin/scheduler")
public class SchedulerController {
    
    @Autowired
    private SchedulerService service;

    @Autowired
    private NewsCrawlingService newsCrawlingService;

    @RequestMapping("list")
    public String list(Model model){

        List<Schedules> list      = newsCrawlingService.getList();
        List<ScheduleLog> logList = service.getLogList();
      
        model.addAttribute("list",    list);
        model.addAttribute("logList", logList);
        return "admin/newsCrawling/list";
    }
}
