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

    //1.1.페이지 클릭(처음 페이지 진입 시 포함, page default = 1)
    @Override
    public List<News> getList(Integer page) {

        return getList(page, null);
    }

    //2.1.뉴스 검색 조회
    @Override
    public List<News> getList(Integer page, String query) {

        int size   = 4;                                             //6;
        int offset = (page-1)*size;
        List<News> list = repository.findAll(query, offset, size);
        return list;
    }

    //1.1.뉴스 전체 건수
    @Override
    public int getCount() {

        return getCount(null);
    }

    //2.2.뉴스 검색 조회 건수
    @Override
    public int getCount(String query) {
        
        int count = repository.Count(query);
        return count;
    }

    @Override
    public void saveNewsData(List<News> list) {
      
        for(int i = 0; i < list.size(); i++){

            News temp = list.get(i);
            Map map = new HashMap(); 

                //idxNo 중복 체크
                String newIdxNo   = temp.getIdxNo();
                Long newsSourceId = temp.getNewsSourceId();
//System.out.println("1.newIdxNo : " + newIdxNo);
                int checkCnt = repository.checkDupNewsData(newIdxNo, newsSourceId);
//System.out.println("1.checkCnt : " + checkCnt);                
                if(checkCnt == 0){
                    
                    map.put("idxNo",          newIdxNo);
                    map.put("link",           temp.getLink());
                    map.put("year",           2024);
                    map.put("newsSourceId",   temp.getNewsSourceId());
                    map.put("title",          temp.getTitle());
                    map.put("imgPath",        temp.getImgPath());
                    map.put("summary",        temp.getSummary());
                    map.put("newsCategoryId", 4);
                    repository.saveNewsData(map);
                }
        }
    }

    









  
   
    
}
