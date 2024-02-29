package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.entity.Category;
import kr.co.mayo.dreamon.service.CategoryService;

@Controller
@RequestMapping("user")
public class UserController {
    
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
