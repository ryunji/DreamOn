package kr.co.mayo.dreamon.entity;

import java.math.BigInteger;
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
    
  //private long   id;
    private BigInteger id;
    private String     displayName;
    private String     name;
    private String     pwd;
    private String     phone;
    private String     email;
    private String     memberTypeCategoryId;
    private String     joinTypeCategoryId;
    private Date       joinDt;
    private Date       withdrawalDt;
}
