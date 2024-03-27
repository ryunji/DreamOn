package kr.co.mayo.dreamon.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("userCommunityController")
@RequestMapping("community")
public class CommunityController {
    
    @GetMapping("user-regist")
    public String userReigst(){

        return "/community/regist";
    }
}
