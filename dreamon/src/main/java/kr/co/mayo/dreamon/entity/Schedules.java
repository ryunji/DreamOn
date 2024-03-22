package kr.co.mayo.dreamon.entity;

import java.util.Date;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedules {
    
    Long id;
    String jobName;
    String url;
    String adminName;
    Date regDate;
}
