package kr.co.mayo.dreamon.service.admin.news;

import java.util.List;

import kr.co.mayo.dreamon.entity.NewsSource;

public interface SourceService {

    List<NewsSource> getList();                                                         //1.뉴스 Source 전체 조회
    List<NewsSource> getData(Long id);                                                  //2.뉴스 Source 단건 조회
    void saveSource(String code, String name, String domain, String url, String useYn); //3.뉴스 Source 저장.
    void updateSource(Long id, String code, String name, String domain, String url, String useYn);
}
