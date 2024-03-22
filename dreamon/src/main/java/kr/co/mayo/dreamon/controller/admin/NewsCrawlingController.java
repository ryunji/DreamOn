package kr.co.mayo.dreamon.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.service.NewsService;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;

@Controller
@RequestMapping("admin/newsCrawling")
public class NewsCrawlingController {
    
    @Autowired
    NewsCrawlingService service;

    @RequestMapping("list")
    public String list(Model model){

        List<Schedules> list = service.getList();
        System.out.println("list : " + list);
        model.addAttribute("list", list);
        return "admin/newsCrawling/list";
    }

    @PostMapping("regist")
    public String regist(String name
                       , String url){
        
        service.schedulerRegist(name, url);

        return "redirect:/admin/newsCrawling/list";
    }
}
