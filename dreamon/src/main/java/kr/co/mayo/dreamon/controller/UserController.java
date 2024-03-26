package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.mayo.dreamon.entity.Category;
import kr.co.mayo.dreamon.entity.Member;
import kr.co.mayo.dreamon.entity.Menu;
import kr.co.mayo.dreamon.service.CategoryService;
import kr.co.mayo.dreamon.service.MemberService;
import kr.co.mayo.dreamon.service.MenuService;
import kr.co.mayo.dreamon.service.NewsService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Autowired
    private NewsService newsService;

    @Autowired
    private MemberService memberservice;

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private MenuService menuService;
   
    @GetMapping("signIn")
    public String signIn(Model model){

         //카테고리 가져오는 로직
         List<Menu> menuList = menuService.findAll();
         System.out.println("menuList : " + menuList);
         model.addAttribute("menuList", menuList);
        return "user/signIn";
    }

    //1.회원가입 화면
    @PostMapping("signIn")
    public String signIn(String username      //input의 name
                       , String password
                       , HttpServletResponse response
                       , Model model){

        boolean valid = memberservice.validate(username, password);
        if(!valid)
            return "redirect:/signin?error";

        Member member = memberservice.getUserId(username);
        
        Cookie uidCookie = new Cookie("uid", String.valueOf(member.getId()));
        uidCookie.setPath("/");
        
        Cookie usernameCookie = new Cookie("username", username);
        usernameCookie.setPath("/");

        response.addCookie(uidCookie);
        response.addCookie(usernameCookie);



       


        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        System.out.println("로그인 화면 진입");
        return "redirect:/index";
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
