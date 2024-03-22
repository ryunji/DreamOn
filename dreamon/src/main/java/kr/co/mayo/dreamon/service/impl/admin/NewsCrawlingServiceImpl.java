package kr.co.mayo.dreamon.service.impl.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.repository.NewsCrawlingRepository;
import kr.co.mayo.dreamon.service.admin.NewsCrawlingService;

@Service
public class NewsCrawlingServiceImpl implements NewsCrawlingService{

    @Autowired
    NewsCrawlingRepository repository;
    
    @Override
    public List<Schedules> getList() {
       
        List<Schedules> list = repository.findAll();
        return list;
    }

    @Override
    public void schedulerRegist(String name, String url) {
        repository.schedulerInsert(name, url);
    }
}
