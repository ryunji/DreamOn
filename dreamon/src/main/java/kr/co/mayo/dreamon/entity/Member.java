package kr.co.mayo.dreamon.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
//회원 클래스
public class Member {
    
    private long   id;
    private int    pwd;
    private String korName;
    private String engName;
    private int    phone;
    private String email;
    private int    typeCategoryId;
    private Date   joinDt;
    private Date   withdrawalDt;
}
