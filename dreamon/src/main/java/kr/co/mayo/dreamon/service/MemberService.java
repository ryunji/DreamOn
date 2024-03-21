package kr.co.mayo.dreamon.service;

import kr.co.mayo.dreamon.entity.Member;

public interface MemberService {

    boolean validate(String username, String password);

    Member getUserId(String username);

    void saveNewMemberInfo(String name, String displayname, String password, String phone, String email, String type);
    
}
