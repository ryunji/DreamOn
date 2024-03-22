package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.Schedules;

@Mapper
public interface NewsCrawlingRepository {

    void schedulerInsert(String name, String url);
    List<Schedules> findAll();
}
