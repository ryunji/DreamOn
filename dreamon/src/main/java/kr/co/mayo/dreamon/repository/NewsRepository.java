package kr.co.mayo.dreamon.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.News;

@Mapper
public interface NewsRepository {
    
    List<News> findAll(String query, int offset, int size);
    int Count(String query);
    void saveNewsData(Map map);
	int checkDupNewsData(String newIdxNo, Long newsSourceId);
    void insertMyNews(Long id);
}
