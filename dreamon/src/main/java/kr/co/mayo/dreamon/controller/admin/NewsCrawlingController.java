package kr.co.mayo.dreamon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.NewsService;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;
import kr.co.mayo.dreamon.service.admin.SchedulerService;

@Controller
@RequestMapping("admin/newsCrawling")
public class NewsCrawlingController {

    @Autowired
    NewsCrawlingService newsCrawlingService;

    @PostMapping("regist")
    public String regist(String name
                       , String url){
        
        newsCrawlingService.schedulerRegist(name, url);

        return "redirect:/admin/newsCrawling/list";
    }
}
