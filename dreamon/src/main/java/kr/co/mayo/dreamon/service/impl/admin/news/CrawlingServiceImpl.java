package kr.co.mayo.dreamon.service.impl.admin.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Schedules;
import kr.co.mayo.dreamon.repository.NewsCrawlingRepository;
import kr.co.mayo.dreamon.repository.SchedulerRepository;
import kr.co.mayo.dreamon.service.admin.news.CrawlingService;

@Service
public class CrawlingServiceImpl implements CrawlingService{

    @Autowired
    private SchedulerRepository repository;
    
    @Autowired
    private NewsCrawlingRepository newsCrawlingRepository;
    
    @Override
    public List<Schedules> getList() {
       
        List<Schedules> list = newsCrawlingRepository.findAll();
        return list;
    }

    @Override
    public void schedulerRegist(String name, String url) {
        
        newsCrawlingRepository.schedulerInsert(name, url);
    }   
}
