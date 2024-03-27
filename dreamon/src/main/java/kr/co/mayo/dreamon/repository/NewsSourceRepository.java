package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.NewsSource;

@Mapper
public interface NewsSourceRepository {

    List<NewsSource> findAll();             //1.뉴스 Source 전체 조회.
    List<NewsSource> findData(Long id);     //2.뉴스 Source 단건 조회.
    void insert(String code, String name, String domain, String url, String useYn);
    void update(Long id, String code, String name, String domain, String url, String useYn);
}
