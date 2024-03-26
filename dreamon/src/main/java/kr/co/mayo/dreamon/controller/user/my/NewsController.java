package kr.co.mayo.dreamon.controller.user.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mayo.dreamon.service.NewsService;

@Controller("myNewsController")
@RequestMapping("myScrapNews")
public class NewsController { 

    @RequestMapping("list")
    public String list(){

        return "/user/my/newsList";
    }
}
