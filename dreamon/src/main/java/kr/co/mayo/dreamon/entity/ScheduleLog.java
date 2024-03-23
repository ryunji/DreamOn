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
public class ScheduleLog {

    Long id;
    Long schedulesId;
    String jobName;
    Long code;
    String status;
    String message;
    Date excutionTime;
    Date regDate;
}