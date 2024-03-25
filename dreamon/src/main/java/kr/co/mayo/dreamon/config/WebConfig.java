package kr.co.mayo.dreamon.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    private String connectPath = "/imagePath/**";

    //윈도우의 경우                     : addResourceLocations("file:///D:/DATA/video/");
    //리눅스 root에서 시작하는 폴더 경로 : .addResourceLocations("file:/DATA/video/");
    private String resourcePath = "file:///D:/class-7/MayoImg/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
}
