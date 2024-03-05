package kr.co.mayo.dreamon.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class News {
    
    long id;
    int year;
    String title;
    String content;
    Date regDate;
    long newsCategoryId;
}
