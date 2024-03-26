package kr.co.mayo.dreamon.controller.admin.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.service.admin.news.CrawlingService;

@Controller("adminCrawlingController")
@RequestMapping("admin/newsCrawling")
public class CrawlingController {

    @Autowired
    CrawlingService newsCrawlingService;

    @PostMapping("regist")
    public String regist(String name
                       , String url){
        
        newsCrawlingService.schedulerRegist(name, url);
        return "redirect:/admin/newsCrawling/list";
    }
}
