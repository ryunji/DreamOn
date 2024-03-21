package kr.co.mayo.dreamon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.Member;
import kr.co.mayo.dreamon.repository.MemberRepository;
import kr.co.mayo.dreamon.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository repository;

    @Override
    public boolean validate(String username, String password) {
       
        Member member = repository.findByUsername(username, password);
        if(member == null)
            return false;

        if(!member.getPwd().equals(password))
            return false;
    
        return true;
    }

    @Override
    public Member getUserId(String username) {

        Member member = repository.findByUsername(username, null);
        return member;
    }

    @Override
    public void saveNewMemberInfo(String name, String displayname, String password, String phone, String email, String type) {
        
        repository.insertMember(name, displayname, password, phone, email, type);
    }
}
