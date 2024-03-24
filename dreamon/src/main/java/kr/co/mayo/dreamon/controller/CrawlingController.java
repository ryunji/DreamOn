package kr.co.mayo.dreamon.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.service.NewsService;
import kr.co.mayo.dreamon.service.admin.NewsSourceService;

//소스예제 : https://velog.io/@soyul2823/Spring-Boot-%EC%9E%90%EB%B0%94-%ED%81%AC%EB%A1%A4%EB%A7%81Crawling-Selenium
@Controller
public class CrawlingController {
    
   
    @Autowired
    private NewsSourceService newsSourceService;

    @Autowired
    private NewsService newsService;
    
    @GetMapping("/crawling")
    public ResponseEntity<Integer> crawling(HttpServletRequest request){

        List<CrawlingDTO> list = new ArrayList<>();

        //자원설정
        String WEB_DRIVER_ID   = "webdriver.chrome.driver";
		String WEB_DRIVER_PATH = "./src/main/resources/static/lib/chromedriver.exe";                                                //"C:\\Users\\gnosi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
		              options.addArguments("--remote-allow-origins=*");
		              options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

        List<NewsSource> newsSourceList = newsSourceService.getList();
        for (NewsSource sourceList : newsSourceList) {
            
            String code = sourceList.getCode();
            String name = sourceList.getName();
            String url  = sourceList.getUrl();
            try {
                 
                //뉴스 데이터를 가져오는 소스제공처 url 주소.
                driver.get(url);                                                                                                   //"https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2&view_type=sm"); //크롤링할 사이트의 url : 뉴스 앤 잡

                //뉴스 리스트 내 데이터 추출
                for(WebElement element : driver.findElements(By.className("article-list"))){
                    
                    CrawlingDTO dto = new CrawlingDTO();
                    
                    //String data = element.getText();
                    //System.out.println("data : " + data);
                    
                    String source = "뉴스앤잡";

                     //1.제목 추출
                     WebElement titles = element.findElement(By.className("list-titles"));                       
                     String title     =   titles.getText();                                  //titles.getAttribute("strong");
                     System.out.println("1.제목(title)" + title);
                     dto.setTitle(title);

                     WebElement imgs = element.findElement(By.className("list-image"));
                     String imgURL   = "https://www.newsnjob.com/news/thumbnail/202403/25495_23005_5132_v150.jpg"; //imgs.getAttribute("style");
                     
                     System.out.println("imgURL : " + imgURL);
                     if (!"".equals(imgURL) && (imgURL.startsWith("http://") || imgURL.startsWith("https://"))) {
                         System.out.println("The address of the picture downloaded: " + imgURL);
                         downImages("D:\\class-7\\MayoImg", imgURL);
                     }

                    WebElement contents = element.findElement(By.className("list-summary"));    
                    String summary     =   contents.getText();                              
                    System.out.println("2.요약(contents)" + summary);
                    dto.setSummary(summary);

                    String idx = element.findElement(By.tagName("a")).getAttribute("href");         
                    System.out.println("3.String idxNo : " + idx);
                    //  int fstIndex = idx.indexOf("=");
                    //  String idxNo = idx.substring(fstIndex+1);
                    //  System.out.println("4.idxNo = " + idxNo);
                    //  dto.setIdxNo(idxNo);

                    //  WebElement imgs = element.findElement(By.className("list-image"));    //tagName
                    //  // String img = imgs.getAttribute("src");
                    //  //dto.setData(data);
                    //  //dto.setImg(img);

                    WebElement categorys = element.findElement(By.className("list-dated"));
                    String category = categorys.getText();
                    System.out.println("category : " + category);

                     list.add(dto);
                 }
                
                    //newsService.saveNewNewsData(list); //신규 뉴스 저장.
                    
                    return ResponseEntity.ok(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.ok(0);
                } finally {
                    driver.close();
                }

            }
        // try {
        //         //뉴스 데이터를 가져오는 소스제공처 url 주소.
        //         driver.get("https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2&view_type=sm"); //크롤링할 사이트의 url 

        //         //뉴스 리스트 내 데이터 추출
        //         for(WebElement element : driver.findElements(By.className("list-block"))){
                    
        //             CrawlingDTO dto = new CrawlingDTO();
                    
        //             //String data = element.getText();
        //             //System.out.println("data : " + data);
                    
        //             //1.제목 추출
        //             WebElement titles = element.findElement(By.className("list-titles"));                       
        //             String title     =   titles.getText();                                  //titles.getAttribute("strong");
        //             //System.out.println("1.제목(title)" + title);
        //             dto.setTitle(title);

        //             WebElement contents = element.findElement(By.className("list-summary"));    
        //             String summary     =   contents.getText();                              
        //             //System.out.println("2.요약(contents)" + summary);
        //             dto.setSummary(summary);

        //             String idx = element.findElement(By.tagName("a")).getAttribute("href");         
        //             //System.out.println("3.String idxNo : " + idx);
        //             int fstIndex = idx.indexOf("=");
        //             String idxNo = idx.substring(fstIndex+1);
        //             System.out.println("4.idxNo = " + idxNo);
        //             dto.setIdxNo(idxNo);

        //             WebElement imgs = element.findElement(By.className("list-image"));    //tagName
        //             // String img = imgs.getAttribute("src");
        //             //dto.setData(data);
        //             //dto.setImg(img);

        //             list.add(dto);
        //         }
                
        //         newsService.saveNewNewsData(list); //신규 뉴스 저장.
                
        //         return ResponseEntity.ok(1);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //         return ResponseEntity.ok(0);
        //     } finally {
        //         driver.close();
        //     }
    }

    private static void downImages(String dir, String imgURL) {


        int FILE_NUM = 0;

        String[] fileName = imgURL.substring(imgURL.lastIndexOf("/")).split("/");

        File files = new File(dir);

        if(!files.exists()){
            files.mkdir();
        }

        try{
            URL url = new URL(imgURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();

            System.out.println("fileName = " + fileName[1]);

            File file = new File(dir + "/" + FILE_NUM + "_"+ fileName[1]);
            FILE_NUM++;
            FileOutputStream out = new FileOutputStream(file);
            int i = 0;

            while((i=is.read()) != -1){
                out.write(i);
            }

            is.close();
            out.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}