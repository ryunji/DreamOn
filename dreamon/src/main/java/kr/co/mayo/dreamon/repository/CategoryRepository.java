package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.Category;

@Mapper
public interface CategoryRepository {
    
    List<Category> findAll();
    List<Category> findAllMemberType();  
}
