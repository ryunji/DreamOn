package kr.co.mayo.dreamon.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.mayo.dreamon.entity.InterviewCard;
import kr.co.mayo.dreamon.entity.InterviewCardView;
import kr.co.mayo.dreamon.service.InterviewService;

@Controller()
@RequestMapping("interview")
public class InterviewController {
    
    @Autowired
    private InterviewService service;

    @GetMapping("card-list")
    public String cardList(Model model){

        List<InterviewCardView> cards = new ArrayList<>(); 
        cards = service.getList();
        
        model.addAttribute("cards", cards);
        return "menu/interview";
    }
}
