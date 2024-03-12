package kr.co.mayo.dreamon.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

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

    @GetMapping("my-list")
    public String myList(@CookieValue(required = false) String interviewCards
                       , Model model){

        List<InterviewCard> interveiwCardList;
        if(interviewCards == null)
            
            interveiwCardList = new ArrayList<>();
        else{

            //Decode
            String interviewCardStr = URLDecoder.decode(interviewCards, Charset.forName("utf-8"));
            interveiwCardList = new Gson().fromJson(interviewCardStr, List.class);
        }

        model.addAttribute("interviewCards", interveiwCardList);
        return "user/myInterviewCardList";
    }

    //1.인터뷰 카드 나의 인터뷰 카드로 담기.
    @PostMapping("add-interview-card")
    public String addCard(Long id
                        , @CookieValue(required = false) String interviewCards
                        , HttpServletResponse response){

        System.out.println("1.interviewCardId : " + id);
        
        List<InterviewCard> interveiwCardList;                        
        {
            if(interviewCards == null)
                
            interveiwCardList = new ArrayList<>();
            else{

                String interviewCardStr = URLDecoder.decode(interviewCards, Charset.forName("utf-8"));
                interveiwCardList = new Gson().fromJson(interviewCardStr, List.class);
            }

            InterviewCard interviewCard  = service.getById(id);
            interveiwCardList.add(interviewCard);
        }
        
        {
            //id값으로 인터뷰 카드 정보 1개 조회.
            String cardStr      = new Gson().toJson(interveiwCardList);     //card.toString();
            String cardEncoded  = "";
            try {
                
                cardEncoded  = URLEncoder.encode(cardStr, "utf-8");
            } catch (UnsupportedEncodingException e) {
                
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            Cookie cardCookie = new Cookie("interviewCards", cardEncoded);
                   cardCookie.setPath("/");
    
            cardCookie.setValue(cardEncoded);
            response.addCookie(cardCookie);
        }

        return "redirect:/interview/card-list";
    }
}
