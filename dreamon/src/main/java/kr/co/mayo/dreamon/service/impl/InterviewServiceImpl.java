package kr.co.mayo.dreamon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mayo.dreamon.entity.InterviewCard;
import kr.co.mayo.dreamon.entity.InterviewCardView;
import kr.co.mayo.dreamon.repository.InterviewRepository;
import kr.co.mayo.dreamon.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService{

    @Autowired
    private InterviewRepository repository;    
    
    @Override
    public List<InterviewCardView> getList() {
        List<InterviewCardView> cards = repository.findAll();
        return cards;
    }    
    
    @Override
    public InterviewCard getById(Long id) {
        
        InterviewCard card = repository.findById(id);
        return card;
    }
}
