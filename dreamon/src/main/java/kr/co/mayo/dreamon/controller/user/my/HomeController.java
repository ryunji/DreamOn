package kr.co.mayo.dreamon.controller.user.my;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import kr.co.mayo.dreamon.entity.InterviewCard;

@Controller("myHomeController")
@RequestMapping("my")
public class HomeController {
    
    @GetMapping("home")
    public String home(@CookieValue(required = false) String interviewCards
                       , Model model){

        return "user/my/home";
    }
}
