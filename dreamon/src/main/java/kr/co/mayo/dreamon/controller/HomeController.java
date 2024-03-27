package kr.co.mayo.dreamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("home")
    public String index(){

        return "index";
    }

    @GetMapping("inquiry")
    public String inquiry(){

        return "/home/inquiry";
    }
}