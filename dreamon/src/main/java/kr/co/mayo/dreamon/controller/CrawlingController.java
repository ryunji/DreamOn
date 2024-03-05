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
import kr.co.mayo.dreamon.entity.News;
import kr.co.mayo.dreamon.service.NewsService;

@Controller
public class CrawlingController {
    
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/crawling")
    public ResponseEntity<Integer> crawling(HttpServletRequest request){
    	List<CrawlingDTO> list = new ArrayList<>();

        System.out.println("1");
        String WEB_DRIVER_ID = "webdriver.chrome.driver";
		String WEB_DRIVER_PATH = "C:\\Users\\gnosi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
        System.out.println("2");
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("headless");
        System.out.println("3");
		WebDriver driver = new ChromeDriver(options);
		System.out.println("4");
        try {
                driver.get("https://www.newsnjob.com/news/articleList.html?sc_section_code=S1N2"); //크롤링할 사이트의 url 
                System.out.println("5");
                for(WebElement element : driver.findElements(By.className("table-row"))){
                    System.out.println("6");
                    String data = element.getText();
                    System.out.println("7");
                    System.out.println("datatata : " + data);
                    // WebElement imgs = element.findElement(By.tagName("img"));
                    // System.out.println("8");
                    // String img = imgs.getAttribute("src");
                    // System.out.println("9");
                    CrawlingDTO dto = new CrawlingDTO();
                    dto.setData(data);
                    //dto.setImg(img);

                    list.add(dto);


                    newsService.saveNewNewsData(list); //뉴스 저장.


                }
                return ResponseEntity.ok(1);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.ok(0);
            } finally {
                driver.close();
            }
    }
}