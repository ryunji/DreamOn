package kr.co.mayo.dreamon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.repository.NewsRepository;
import kr.co.mayo.dreamon.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsRepository repository;
    @Override
    public List<News> getNewsList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNewsList'");
    }

    @Override
    public void saveNewNewsData(List<CrawlingDTO> list) {
      
        for(int i = 0; i < list.size(); i++){
            System.out.println("1");
            CrawlingDTO temp = list.get(i);
            Map map = new HashMap(); 

            System.out.println("2");
                map.put("year",    2024);
                map.put("title",   temp.getTitle());
                map.put("summary", temp.getSummary());
                map.put("newsCategoryId", 4);
                map.put("idxNo", temp.getIdxNo());

                repository.saveNewNewsData(map);
        }
    }

   
    
}
