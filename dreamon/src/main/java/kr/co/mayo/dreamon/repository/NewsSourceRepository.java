package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.NewsSource;

@Mapper
public interface NewsSourceRepository {

    List<NewsSource> findAll();    
}
