package kr.co.mayo.dreamon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("community")
public class CommunityController {

    @GetMapping("list")
    public String list(){

        return "community/list";
    }
}