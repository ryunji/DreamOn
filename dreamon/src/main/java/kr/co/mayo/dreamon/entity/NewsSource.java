package kr.co.mayo.dreamon.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsSource {
    
    Long id;
    String code;
    String name;
    String url;
}
