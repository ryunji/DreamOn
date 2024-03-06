package kr.co.mayo.dreamon.service;

import java.util.List;

import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.News;

public interface NewsService {
 
    //List<News> getNewsList();                           //창업 뉴스 조회
    void saveNewNewsData(List<CrawlingDTO> list);
    List<News> findAll(Integer page);
    int getNewsCnt();
}
