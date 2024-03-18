package kr.co.mayo.dreamon.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mento {
    
    String id;
    String introduction;
    String expertise;
    String career;
    String sns;
}
