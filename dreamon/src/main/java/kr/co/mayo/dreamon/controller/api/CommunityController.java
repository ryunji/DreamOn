package kr.co.mayo.dreamon.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("apiCommunityController")
@RequestMapping("api/community")
public class CommunityController {

    @PostMapping("regist")
    public void regist(String editorData){

        System.out.println("sdfdsf : " + editorData);
    }
}
