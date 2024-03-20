package kr.co.mayo.dreamon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.service.MemberService;

@Controller()
@RequestMapping("member")
public class JoinController {
    
    @Autowired
    private MemberService memberService;

    @RequestMapping("join")
    public String join(){

        return "user/join";
    }

    @PostMapping("join")
    public String join(String korname      //input의 name
                     , String password
                     , String engname      //input의 name
                     , String phone
                     , String email      //input의 name
                     ){
        
        memberService.saveNewMemberInfo(korname, password, engname, phone, email);                
        
        //그냥 페이지를 쓰면 css를 먹지 않음.
        return "redirect:/index";
    }
}
