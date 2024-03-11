package kr.co.mayo.dreamon.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mayo.dreamon.entity.InterviewCard;
import kr.co.mayo.dreamon.entity.InterviewCardView;

@Mapper
public interface InterviewRepository {

    List<InterviewCardView> findAll();  //1.인터뷰 카드 전체조회
    InterviewCard findById(Long id);           //2.비 로그인 시, 쿠키에 담을 인터뷰 카드 정보
}

