package kr.co.mayo.dreamon.service.admin.news;

import java.util.List;

import kr.co.mayo.dreamon.entity.Schedules;

public interface CrawlingService{

    //1.스케쥴 리스트 조회
    List<Schedules> getList();
       
    //뉴스 스케줄러 등록
    void schedulerRegist(String name, String url);
}
