package kr.co.mayo.dreamon.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import groovyjarjarantlr4.v4.parse.ANTLRParser.blockEntry_return;
import jakarta.servlet.http.HttpServletRequest;
import kr.co.mayo.dreamon.dto.CrawlingDTO;
import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.entity.NewsSource;
import kr.co.mayo.dreamon.service.NewsService;
import kr.co.mayo.dreamon.service.admin.NewsSourceService;

//소스예제 : https://velog.io/@soyul2823/Spring-Boot-%EC%9E%90%EB%B0%94-%ED%81%AC%EB%A1%A4%EB%A7%81Crawling-Selenium
@Controller
public class CrawlingController {
    
    private static int FILE_NUM = 0;

    @Autowired
    private NewsSourceService newsSourceService;

    @Autowired
    private NewsService newsService;

    private News news;
    
    @GetMapping("/crawling")
    public ResponseEntity<Integer> crawling(HttpServletRequest request){

        List<News> list = new ArrayList<>();

        //자원설정
        String WEB_DRIVER_ID   = "webdriver.chrome.driver";
		String WEB_DRIVER_PATH = "./src/main/resources/static/lib/chromedriver.exe";                                                //"C:\\Users\\gnosi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        String baseFolderPath  = "D:\\class-7\\MayoImg";

        ChromeOptions options = new ChromeOptions();
		              options.addArguments("--remote-allow-origins=*");
		              options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);
          
        String targetUrl = "https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2&view_type=sm";
        try {
                 
            //뉴스 데이터를 가져오는 소스제공처 url 주소.
            driver.get(targetUrl);                                                                                                   //"https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2&view_type=sm"); //크롤링할 사이트의 url : 뉴스 앤 잡

            int index = 1;
            //뉴스 리스트 내 데이터 추출
            for(WebElement element : driver.findElements(By.className("list-block"))){
            
                news = new News();

                //1.제목 추출
                WebElement titleElm = element.findElement(By.className("list-titles"));                       
                String title     =   titleElm.getText();                                  //titles.getAttribute("strong");
System.out.println(index + "제목 : " + title);
                
                //2.이미지 url 추출
                WebElement imgElm = element.findElement(By.className("list-image"));
                String imgURL = imgElm.getAttribute("style");
System.out.println("imgURL : " + imgURL);
                int start = imgURL.indexOf("\"") + 1;
                int end   = imgURL.indexOf("\"", start);
                imgURL    = imgURL.substring(start, end);        
System.out.println("imgURL : " + imgURL);
                imgURL    = imgURL.replaceFirst(".", "https://www.newsnjob.com/news");
                String imgPath = "";
                if (!"".equals(imgURL) && (imgURL.startsWith("http://") || imgURL.startsWith("https://"))) {
                         
System.out.println("The address of the picture downloaded: " + imgURL);
                    imgPath = preWorkToDown(baseFolderPath, imgURL);
                }  

                //3.요약발췌
                WebElement summaryElm = element.findElement(By.className("list-summary"));
                String summary        = summaryElm.getText();
                System.out.println("summary : " + summary);

                //4.하단 출처관련 데이터

                // WebElement subDataElm = element.findElement(By.className("byline"));

                // // 하위 요소를 찾을 By 로케이터 정의
                // By bySubDataElement = By.cssSelector("em");

                // // 하위 요소 목록 가져오기
                // List<WebElement> subDataElements = subDataElm.findElements(bySubDataElement);
                // for (WebElement subDataElement : subDataElements) {
                //     // 각 하위 요소에 대한 작업 수행
                //     // 예: 텍스트 추출
                //     System.out.println(subDataElement.getText());
                // }

                news.setTitle(imgURL);
                news.setImgPath(imgPath);
                news.setSummary(summary);

                index++;
            }
        
            //newsService.saveNewNewsData(list); //신규 뉴스 저장.
            
            return ResponseEntity.ok(1);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(0);
        } finally {
            driver.close();
        }

       
        /*try {
            //뉴스 데이터를 가져오는 소스제공처 url 주소.
            driver.get("http://www.kmedia-news.com/news/articleList.html?sc_section_code=S1N51&view_type=sm"); //크롤링할 사이트의 url 

            //뉴스 리스트 내 데이터 추출
            for(WebElement element : driver.findElements(By.tagName("li"))){

                News news = new News();   
         
                //1.제목 추출
                WebElement titles = element.findElement(By.className("titles"));         
                String title      =   titles.getText();                                
                
                WebElement imgs   = element.findElement(By.tagName("img"));
                String downImgUrl = imgs.getAttribute("src") ; 
                String imgPath    = "";
                if (!"".equals(downImgUrl) && (downImgUrl.startsWith("http://") || downImgUrl.startsWith("https://"))) {
                         
                    System.out.println("The address of the picture downloaded: " + downImgUrl);
                    
                    imgPath = preWorkToDown(baseFolderPath, downImgUrl);
                }                
                
                WebElement summary   = element.findElement(By.className("lead"));
                String contents = summary.getText();
                System.out.println("contnet : " + contents);

                news.setTitle(title);
                news.setImgPath(imgPath);
                news.setSummary(contents);
                news.setIdxNo("1");
                list.add(news);
            }
    
            newsService.saveNewNewsData(list); //신규 뉴스 저장.
            return ResponseEntity.ok(1);
        } catch (Exception e) {
        e.printStackTrace();
            return ResponseEntity.ok(0);
        } finally {
            driver.close();
        }*/
    }

    //2.뉴스 관련 이미지 다운로드.
    private static String preWorkToDown(String baseFolderPath, String downImgUrl) {

        //파일의 이름 추출
        String[] fileName = downImgUrl.substring(downImgUrl.lastIndexOf("/")).split("/");        
        
        String downPath = makeFolderPath(baseFolderPath);
        String imgPath  = downToFolder(downPath, downImgUrl, fileName);
        return imgPath;
    }

    //폴더 경로 생성.
    private static String makeFolderPath(String baseFolderPath) {

        String str        = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = str.replace("/", File.separator); //각기 다른 브라우저를 위한 구분자 교체
               folderPath = baseFolderPath + "/" + folderPath;

        //make folder
        File downFilePath = new File(folderPath);
        
        if(!downFilePath.exists())
            downFilePath.mkdirs();

        return folderPath;
    }

     //폴더 경로 생성.
     private static String downToFolder(String downPath, String downImgUrl, String[] fileName) {
     
        String imgPath = "";
        try{
            
            URL url                      = new URL(downImgUrl);                                 //이미지를 가져올 url 경로.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is               = connection.getInputStream();

            System.out.println("fileName = " + fileName[1]);

          //imgPath = downPath + "/" + FILE_NUM + "_"+ fileName[1];
            imgPath = downPath + "/" + fileName[1];
            File file = new File(imgPath);
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
        
        return imgPath;
    }
}