package kr.co.mayo.dreamon.controller.admin.News;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;
import kr.co.mayo.dreamon.service.admin.SchedulerService;
import kr.co.mayo.dreamon.service.admin.News.NewsSourceService;

@Controller
@RequestMapping("admin/newsSource")
public class SourceController {
    
    @Autowired
    private NewsSourceService service;

    @RequestMapping("list")
    public String list(Model model){

        List<NewsSource> list = service.getList();
      System.out.println("list : " + list);
        model.addAttribute("list",    list);
        return "admin/newsSource/list";
    }
}
