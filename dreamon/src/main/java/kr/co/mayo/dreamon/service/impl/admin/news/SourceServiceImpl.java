package kr.co.mayo.dreamon.service.impl.admin.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.repository.NewsSourceRepository;
import kr.co.mayo.dreamon.service.admin.news.SourceService;

@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private NewsSourceRepository repository;
    
    //1.뉴스 Source 전체 조회
    @Override
    public List<NewsSource> getList() {
        
        List<NewsSource> list = repository.findAll();
        return list;
    }

    //2.뉴스 Source 단건 조회
    @Override
    public List<NewsSource> getData(Long id) {
        
        List<NewsSource> list = repository.findData(id);
        return list;
    }

    @Override
    public void saveSource(String code, String name, String domain, String url, String useYn) {
    
        repository.insert(code, name, domain, url, useYn);
    }

    @Override
    public void updateSource(Long id, String code, String name, String domain, String url, String useYn) {
        
        System.out.println("여기 안 오나?");
        System.out.println("여기 안 오나? id : " + id);
        repository.update(id, code, name, domain, url, useYn);
    }
}
