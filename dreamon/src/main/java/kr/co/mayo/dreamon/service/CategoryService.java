package kr.co.mayo.dreamon.service;

import java.util.List;

import kr.co.mayo.dreamon.entity.Category;

public interface CategoryService {
    
    List<Category> getList();
    List<Category> getMemberTypeLsit();
}
