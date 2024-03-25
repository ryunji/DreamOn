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
    String idxNo;
    int year;
    String title;
    String imgPath;
    String summary;
    Date regDate;
    long newsCategoryId;
}
