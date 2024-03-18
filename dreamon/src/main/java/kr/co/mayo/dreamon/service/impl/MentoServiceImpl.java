package kr.co.mayo.dreamon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Mento;
import kr.co.mayo.dreamon.repository.MentoRepository;
import kr.co.mayo.dreamon.service.MentoService;

@Service
public class MentoServiceImpl implements MentoService{

    @Autowired
    private MentoRepository repository;
    
    //1. Mento 리스트 화면 : 3명씩 출력하는 걸로...
    @Override
    public List<Mento> findAll() {
      
        List<Mento> list = repository.getMentoList();
        return list;
    }
}
