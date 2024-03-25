package kr.co.mayo.dreamon.service.impl.admin.News;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.repository.NewsSourceRepository;
import kr.co.mayo.dreamon.service.admin.News.NewsSourceService;

@Service
public class NewsSourceServiceImpl implements NewsSourceService {

    @Autowired
    private NewsSourceRepository repository;
    
    @Override
    public List<NewsSource> getList() {
        
        List<NewsSource> list = repository.findAll();
        return list;
    }
}
