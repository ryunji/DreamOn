package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.Member;

@Mapper
public interface MemberRepository {
    
    List<Member> findAll();
    
}
