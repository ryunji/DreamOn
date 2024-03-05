package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mayo.dreamon.entity.News;

@Controller
public class CallendarController {
    
    //2.뉴스 화면
    @GetMapping("my")
    public String news( @RequestParam(name = "p", required = false, defaultValue = "1") Integer page
                      ,  Model model){

        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        
        //List<News> news = newsService.findAll();
        
        return "calendar/selectable";
    }
}
