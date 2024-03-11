package kr.co.mayo.dreamon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InterviewCardView {
 
    private Long id;
    private String korName;
    private String mainQuestion;
}
