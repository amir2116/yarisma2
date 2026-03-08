package com.example.yarisma.service;

import com.example.yarisma.model.dto.ResponseDto;
import com.example.yarisma.model.entity.Question;
import com.example.yarisma.repository.QuestionRepository;
import com.example.yarisma.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TeamRepository teamRepository;


    public Question getById(Long id) throws RuntimeException {
        Question question= questionRepository.getById(id);
        if(question.getAnsweredTeam()==null) return  question;
        log.error("Answered Question");
        throw new RuntimeException("Answered Question");
    }

    public void authorizeQuestion(Long questionId, Long teamId) {
        Question question= questionRepository.getById(questionId);
        question.setAnsweredTeam(teamRepository.findById(teamId).get());
        questionRepository.save(question);
    }

    public void unauthorizeQuestion(Long questionId) {
        Question question= questionRepository.getById(questionId);
        question.setAnsweredTeam(null);
        questionRepository.save(question);
    }
}
