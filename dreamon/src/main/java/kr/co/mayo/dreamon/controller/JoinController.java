package kr.co.mayo.dreamon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.service.MemberService;

@Controller()
@RequestMapping("user")
public class JoinController {
    
    @Autowired
    private MemberService memberService;

    //1.view 반환
    @RequestMapping("join")
    public String join(){

        return "user/join";
    }

    //2.회원가입(저장)
    @PostMapping("join")
    public String join(String name          //이름
                     , String displayname   //닉네임
                     , String password      //비밀번호
                     , String phone         //연락처
                     , String email         //이메일
                     , String type          //회원타입
                     ){
        
        type = "1";
        memberService.saveNewMemberInfo(name, displayname, password, phone, email, type);                
        
        //그냥 페이지를 쓰면 css를 먹지 않음.
        return "redirect:/index";
    }
}
