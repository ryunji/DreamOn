package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.Member;

@Mapper
public interface MemberRepository {
    
    List<Member> findAll();
    Member findByUsername(String username, String password);
    int getGoogleIdCount(Long googleId);    
    void saveGoogleNewMember(Member member);
    void insertMember(String korname, String password, String engname, String phone, String email);
}
