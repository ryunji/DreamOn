package kr.co.mayo.dreamon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MemberTypeCategory
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    long id;
    String code;
    String name;
    String description;
    String adminId;
}