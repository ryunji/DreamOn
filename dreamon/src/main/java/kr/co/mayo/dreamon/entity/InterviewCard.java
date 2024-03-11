package kr.co.mayo.dreamon.entity;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class InterviewCard {
    
    private Long id;
    private String korName;
    private String mainQuestion;
}
