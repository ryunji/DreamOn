package kr.co.mayo.dreamon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Menu;
import kr.co.mayo.dreamon.repository.MenuRepository;
import kr.co.mayo.dreamon.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {


    @Autowired
    private MenuRepository repository;
    @Override
    public List<Menu> findAll() {
       
        List<Menu> menuList = repository.getMenuList();
        return menuList;
    }

    

    
}
