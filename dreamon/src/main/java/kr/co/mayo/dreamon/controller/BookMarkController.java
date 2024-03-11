package kr.co.mayo.dreamon.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.mayo.dreamon.entity.InterviewCard;
import kr.co.mayo.dreamon.service.InterviewService;

@Controller
@RequestMapping("bookMark")
public class BookMarkController {
    
    @Autowired
    private InterviewService service;

    //1.인터뷰 카드 나의 인터뷰 카드로 담기.
    @PostMapping("add-interview-card")
    public String addCard(Long id
                        , HttpServletResponse response){

        System.out.println("1.interviewCardId : " + id);
        //id값으로 인터뷰 카드 정보 1개 조회.
        InterviewCard card  = service.getById(id);
        String cardStr      = card.toString();
        String cardEncoded  = "";
        try {
            
            cardEncoded  = URLEncoder.encode(cardStr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Cookie cardCookie = new Cookie("card", cardEncoded);
            cardCookie.setPath("/");

        response.addCookie(cardCookie);
        return "redirect:/interview/card-list";
    }
}
