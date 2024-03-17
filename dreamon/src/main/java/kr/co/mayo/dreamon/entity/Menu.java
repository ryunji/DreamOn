package kr.co.mayo.dreamon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Menu {
    

    //private String category;
    String id;
    String korName;
    
}
