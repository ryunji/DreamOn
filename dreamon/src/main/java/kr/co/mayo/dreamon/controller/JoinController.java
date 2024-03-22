package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.mayo.dreamon.config.WebSecurityConfig;
import kr.co.mayo.dreamon.entity.Category;
import kr.co.mayo.dreamon.service.CategoryService;
import kr.co.mayo.dreamon.service.MemberService;

import org.springframework.security.crypto.password.PasswordEncoder;

@Controller()
@RequestMapping("user")
public class JoinController {
    
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MemberService memberService;

    //1.view 반환
    @RequestMapping("join")
    public String join(Model model){

        List<Category> memberTypeList = categoryService.getMemberTypeLsit();
        model.addAttribute("memberTypeList", memberTypeList);
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
        
        //password = passwordEncoder.encode(password);
        System.out.println("11111: " + password);

        memberService.saveNewMemberInfo(name, displayname, password, phone, email, type);                
        
        //그냥 페이지를 쓰면 css를 먹지 않음.
        return "redirect:/index";
    }
}
