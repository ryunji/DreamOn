package kr.co.mayo.dreamon.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsRepository {
    
    void saveNewNewsData(Map map);
}
