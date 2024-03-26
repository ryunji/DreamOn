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
    
    long   id;
    String idxNo;
    Long   newsSourceId;
    int    year;
    String title;
    String link;
    String imgPath;
    String summary;
    String writer;
    String info;
    String writeDate;
    Date   regDate;
    long   newsCategoryId;
}
