package kr.co.mayo.dreamon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Category;
import kr.co.mayo.dreamon.entity.Member;
import kr.co.mayo.dreamon.repository.CategoryRepository;
import kr.co.mayo.dreamon.repository.MemberRepository;
import kr.co.mayo.dreamon.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository repository;
    
    @Override
    public List<Category> getList() {
        
        
        List<Category> list = repository.findAll();
        System.out.println("리스트 찍어줘라 : " + list);
        return list;
    }
    
}
