package kr.co.mayo.dreamon.controller;

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
import kr.co.mayo.dreamon.service.NewsService;

//소스예제 : https://velog.io/@soyul2823/Spring-Boot-%EC%9E%90%EB%B0%94-%ED%81%AC%EB%A1%A4%EB%A7%81Crawling-Selenium
@Controller
public class CrawlingController {
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/crawling")
    public ResponseEntity<Integer> crawling(HttpServletRequest request){

        List<CrawlingDTO> list = new ArrayList<>();

        //자원설정
        String WEB_DRIVER_ID   = "webdriver.chrome.driver";
		String WEB_DRIVER_PATH = "./src/main/resources/static/lib/chromedriver.exe";
      //String WEB_DRIVER_PATH = "C:\\Users\\gnosi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
		              options.addArguments("--remote-allow-origins=*");
		              options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

        try {
                //뉴스 데이터를 가져오는 소스제공처 url 주소.
                driver.get("https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2&view_type=sm"); //크롤링할 사이트의 url 

                //뉴스 리스트 내 데이터 추출
                for(WebElement element : driver.findElements(By.className("list-block"))){
                    
                    CrawlingDTO dto = new CrawlingDTO();
                    
                    //String data = element.getText();
                    //System.out.println("data : " + data);
                    
                    //1.제목 추출
                    WebElement titles = element.findElement(By.className("list-titles"));                       
                    String title     =   titles.getText();                                  //titles.getAttribute("strong");
                    //System.out.println("1.제목(title)" + title);
                    dto.setTitle(title);

                    WebElement contents = element.findElement(By.className("list-summary"));    
                    String summary     =   contents.getText();                              
                    //System.out.println("2.요약(contents)" + summary);
                    dto.setSummary(summary);

                    String idx = element.findElement(By.tagName("a")).getAttribute("href");         
                    //System.out.println("3.String idxNo : " + idx);
                    int fstIndex = idx.indexOf("=");
                    String idxNo = idx.substring(fstIndex+1);
                    System.out.println("4.idxNo = " + idxNo);
                    dto.setIdxNo(idxNo);

                    WebElement imgs = element.findElement(By.className("list-image"));    //tagName
                    // String img = imgs.getAttribute("src");
                    //dto.setData(data);
                    //dto.setImg(img);

                    list.add(dto);
                }
                
                newsService.saveNewNewsData(list); //신규 뉴스 저장.
                
                return ResponseEntity.ok(1);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok(0);
            } finally {
                driver.close();
            }
    }
}