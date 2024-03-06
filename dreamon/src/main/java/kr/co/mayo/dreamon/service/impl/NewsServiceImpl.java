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
    public List<News> findAll(Integer page) {

        int size = 6;
        int offset = (page-1)*size;
        List<News> list = repository.getNewsList(offset, size);
        return list;
    }

    @Override
    public void saveNewNewsData(List<CrawlingDTO> list) {
      
        for(int i = 0; i < list.size(); i++){

            CrawlingDTO temp = list.get(i);
            Map map = new HashMap(); 

                //idxNo 중복 체크
                String newIdxNo = temp.getIdxNo();
                System.out.println("1.newIdxNo : " + newIdxNo);
                int checkCnt = repository.checkDupNewsData(Integer.parseInt(newIdxNo));
                if(checkCnt == 0){
                    
                    map.put("year",           2024);
                    map.put("title",          temp.getTitle());
                    map.put("summary",        temp.getSummary());
                    map.put("newsCategoryId", 4);
                    map.put("idxNo",          newIdxNo);
                    repository.saveNewNewsData(map);
                }
        }
    }

    @Override
    public int getNewsCnt() {
       
        int newsCnt = repository.getNewsCount();
        return newsCnt;
    }

   
    
}
