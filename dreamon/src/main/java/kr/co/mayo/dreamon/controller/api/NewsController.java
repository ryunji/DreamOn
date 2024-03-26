package kr.co.mayo.dreamon.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.service.NewsService;
import kr.co.mayo.dreamon.service.admin.news.SourceService;

@RestController("apiNewsController")
@RequestMapping("api/news")
public class NewsController {
    
     @Autowired
    private NewsService service;
   
    @Autowired
    private SourceService Sourceservice;

    //뉴스 Source 단건 조회.
    @RequestMapping("data")
    public List<NewsSource> data(@RequestParam(name = "id", required = false) Long id){

        List<NewsSource> data = Sourceservice.getData(id);
        System.out.println("data : " + data);
        return data;
    }

    //뉴스 Source 단건 조회.
    @PostMapping("scrap-news")
    public void scrapNews(@RequestParam(name = "id", required = false) Long id
                        , HttpSession session){

        String userNm = (String) session.getAttribute("username");
        System.out.println("userNm : " + userNm);               
        service.scrapNews(id);
    }
}
