package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mayo.dreamon.entity.Category;
import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.selenium.CrawlingExample;
import kr.co.mayo.dreamon.service.CategoryService;
import kr.co.mayo.dreamon.service.NewsService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private NewsService newsService;

    @Autowired
    private CategoryService categoryService;
    
    //1.회원가입 화면
    @GetMapping("signIn")
    public String signIn(){

        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        System.out.println("로그인 화면 진입");
        return "user/signIn";
    }

    //2.뉴스 화면
    @GetMapping("news")
    public String news( @RequestParam(name = "p", required = false, defaultValue = "1") Integer page
                      ,  Model model){

        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        
        List<News> news = newsService.findAll();
        model.addAttribute("news", news);
        System.out.println("창업 뉴스 리스트 화면");
        return "menu/news";
    }


    //2.에디터 호출화면
    @GetMapping("input")
    public String input(){

        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        System.out.println("로그인 화면 진입");
        return "user/input";
    }
    
    @GetMapping("home")
    public String home(Model model){


        CrawlingExample ex = new CrawlingExample();
System.out.println("어떻게 실행하는겨");
        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        System.out.println("홈화면 진입");
        
        List<Category> categories = categoryService.getList();
        Category category = categories.get(0);
        System.out.println("categories!! : " + category.getName());
        model.addAttribute("categories", categories);
        return "index";
    }
}
