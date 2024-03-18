package kr.co.mayo.dreamon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.service.NewsService;

@Controller
@RequestMapping("news")
public class NewsController {
    
    @Autowired
    private NewsService newsService;

    //1.창업 뉴스 메인 리스트 화면 호출
    @GetMapping("list")
    public String list(  @RequestParam(name = "p", required = false, defaultValue = "1") Integer page
                       , Model model){

        List<News> list = newsService.findAll(page);
        int count       = newsService.getNewsCnt();

        model.addAttribute("newsList", list);
        model.addAttribute("count",    count);
        return "news/list";
    }
}