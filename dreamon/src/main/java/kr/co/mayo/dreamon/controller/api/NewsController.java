package kr.co.mayo.dreamon.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.service.admin.News.NewsSourceService;

@RestController("apiNewsController")
@RequestMapping("api/news")
public class NewsController {
    
    @Autowired
    private NewsSourceService service;

    //뉴스 Source 단건 조회.
    @RequestMapping("data")
    public List<NewsSource> data(@RequestParam(name = "id", required = false) Long id){

        List<NewsSource> data = service.getData(id);
        System.out.println("data : " + data);
        return data;
    }
}
