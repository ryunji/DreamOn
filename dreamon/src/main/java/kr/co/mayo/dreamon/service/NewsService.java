package kr.co.mayo.dreamon.service;

import java.util.List;

import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.News;

//창업 뉴스 조회 서비스
public interface NewsService {
 
    List<News> getList(Integer page);               //1.1.페이지 클릭(처음 페이지 진입 시 포함, page default = 1)
    int getCount();                                 //1.1.뉴스 전체 건수
    List<News> getList(Integer page, String query); //2.1.뉴스 검색 조회
    int getCount(String query);                     //2.2.뉴스 검색 조회 건수
    void saveNewNewsData(List<CrawlingDTO> list);
}
