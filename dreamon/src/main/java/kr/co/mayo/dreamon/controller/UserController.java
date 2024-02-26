package kr.co.mayo.dreamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    
    //1.회원가입 화면
    @GetMapping("signIn")
    public String signIn(){

        //17Line에 /user/signin으로 해서 다음과 같은 에러 발생
        //org.thymeleaf.exceptions.TemplateInputException: Error resolving template [/user/signin], template might not exist or might not be accessible by any of the configured Template Resolvers
        System.out.println("로그인 화면 진입");
        return "user/signIn";
    }
    
}
