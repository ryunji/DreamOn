package kr.co.mayo.dreamon.service;

import java.util.List;

import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.Menu;
import kr.co.mayo.dreamon.entity.News;

public interface MenuService {
 
    List<Menu> findAll();
}
