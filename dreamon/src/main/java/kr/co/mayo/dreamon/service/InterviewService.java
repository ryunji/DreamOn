package kr.co.mayo.dreamon.service;

import java.util.List;

import kr.co.mayo.dreamon.entity.InterviewCard;
import kr.co.mayo.dreamon.entity.InterviewCardView;

public interface InterviewService {

    List<InterviewCardView> getList();  //1.인터뷰 카드 리스트 조회
    InterviewCard getById(Long id);     //2.비 로그인 시, 쿠키에 담을 인터뷰 카드 정보 조회.  
}
