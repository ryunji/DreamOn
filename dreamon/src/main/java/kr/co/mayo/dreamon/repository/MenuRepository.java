package kr.co.mayo.dreamon.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.Menu;
import kr.co.mayo.dreamon.entity.News;

@Mapper
public interface MenuRepository {
   
    List<Menu> getMenuList();
    void insertMember(String korname, String password,  String engname, String phone, String email);
}
