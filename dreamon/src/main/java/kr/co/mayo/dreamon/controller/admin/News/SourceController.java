package kr.co.mayo.dreamon.controller.admin.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.entity.ScheduleLog;
import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.admin.SchedulerService;
import kr.co.mayo.dreamon.service.admin.news.CrawlingService;
import kr.co.mayo.dreamon.service.admin.news.SourceService;

@Controller
@RequestMapping("admin/newsSource")
public class SourceController {
    
    @Autowired
    private SourceService service;

    @RequestMapping("list")
    public String list(Model model){

        List<NewsSource> list = service.getList();
        model.addAttribute("list",    list);
        return "admin/newsSource/list";
    }

    @PostMapping("regist")
    public String regist(String code   //코드
                       , String name   //서비스명
                       , String domain //도메인
                       , String url    //source url
                       , String useYn  //사용여부
                       ){

System.out.println("asdfasdfasdfasdf");

      service.saveSource(code, name, domain, url, useYn);
      return "redirect:/admin/newsSource/list";
    }
}
