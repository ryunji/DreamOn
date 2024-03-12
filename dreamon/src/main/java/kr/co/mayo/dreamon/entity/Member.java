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
//회원 클래스
public class Member {
    
    private long   id;
    private String pwd;
    private String korName;
    private String engName;
    private int    phone;
    private String email;
    private int    typeCategoryId;
    private Date   joinDt;
    private Date   withdrawalDt;
}
