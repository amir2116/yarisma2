package com.example.yarisma.config;

import com.example.yarisma.model.entity.Question;
import com.example.yarisma.model.entity.Team;

import static com.example.yarisma.model.enums.QuestionConstant.*;
import static com.example.yarisma.model.enums.TeamConstant.*;

import com.example.yarisma.model.enums.QuestionConstant;
import com.example.yarisma.model.enums.TeamConstant;
import com.example.yarisma.repository.QuestionRepository;
import com.example.yarisma.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Configurations {
    @Bean
    public CommandLineRunner commandLineRunner(TeamRepository teamRepository, QuestionRepository questionRepository) {
        return args -> {
            teamRepository.saveAll(
                    List.of(
                            updateTeam(teamRepository, TEAM1),
                            updateTeam(teamRepository, TEAM2),
                            updateTeam(teamRepository, TEAM3),
                            updateTeam(teamRepository, TEAM4),
                            updateTeam(teamRepository,TEAM5)
                    )
            );
            questionRepository.saveAll(
                    List.of(
                            updateQuestion(questionRepository, QUESTION_1),
                            updateQuestion(questionRepository, QUESTION_2),
                            updateQuestion(questionRepository, QUESTION_3),
                            updateQuestion(questionRepository, QUESTION_4),
                            updateQuestion(questionRepository, QUESTION_5),
                            updateQuestion(questionRepository, QUESTION_6),
                            updateQuestion(questionRepository, QUESTION_7),
                            updateQuestion(questionRepository, QUESTION_8),
                            updateQuestion(questionRepository, QUESTION_9),
                            updateQuestion(questionRepository, QUESTION_10),

                            updateQuestion(questionRepository, QUESTION_11),
                            updateQuestion(questionRepository, QUESTION_12),
                            updateQuestion(questionRepository, QUESTION_13),
                            updateQuestion(questionRepository, QUESTION_14),
                            updateQuestion(questionRepository, QUESTION_15),
                            updateQuestion(questionRepository, QUESTION_16),
                            updateQuestion(questionRepository, QUESTION_17),
                            updateQuestion(questionRepository, QUESTION_18),
                            updateQuestion(questionRepository, QUESTION_19),
                            updateQuestion(questionRepository, QUESTION_20),

                            updateQuestion(questionRepository, QUESTION_21),
                            updateQuestion(questionRepository, QUESTION_22),
                            updateQuestion(questionRepository, QUESTION_23),
                            updateQuestion(questionRepository, QUESTION_24),
                            updateQuestion(questionRepository, QUESTION_25),
                            updateQuestion(questionRepository, QUESTION_26),
                            updateQuestion(questionRepository, QUESTION_27),
                            updateQuestion(questionRepository, QUESTION_28),
                            updateQuestion(questionRepository, QUESTION_29),
                            updateQuestion(questionRepository, QUESTION_30),

                            updateQuestion(questionRepository, QUESTION_31),
                            updateQuestion(questionRepository, QUESTION_32),
                            updateQuestion(questionRepository, QUESTION_33),
                            updateQuestion(questionRepository, QUESTION_34),
                            updateQuestion(questionRepository, QUESTION_35),
                            updateQuestion(questionRepository, QUESTION_36),
                            updateQuestion(questionRepository, QUESTION_37),
                            updateQuestion(questionRepository, QUESTION_38),
                            updateQuestion(questionRepository, QUESTION_39),
                            updateQuestion(questionRepository, QUESTION_40),

                            updateQuestion(questionRepository, QUESTION_41),
                            updateQuestion(questionRepository, QUESTION_42),
                            updateQuestion(questionRepository, QUESTION_43),
                            updateQuestion(questionRepository, QUESTION_44),
                            updateQuestion(questionRepository, QUESTION_45),
                            updateQuestion(questionRepository, QUESTION_46),
                            updateQuestion(questionRepository, QUESTION_47),
                            updateQuestion(questionRepository, QUESTION_48),
                            updateQuestion(questionRepository, QUESTION_49),
                            updateQuestion(questionRepository, QUESTION_50)
                    )
            );

        };

    }

    public Team updateTeam(TeamRepository teamRepository, TeamConstant teamConstant) {
        Team team = teamRepository.findById(teamConstant.getId()).orElse(new Team(teamConstant.getId()));
        team.setName(teamConstant.getName());
        team.setColor(teamConstant.getColor());
        return team;
    }


    public Question updateQuestion(QuestionRepository questionRepository, QuestionConstant questionConstant) {
        Question question = questionRepository.findById(questionConstant.getId()).orElse(new Question(questionConstant.getId()));
//        question.setQuestionTab(questionConstant.getQuestionTab());
        question.setQuestionType(questionConstant.getQuestionType());
        question.setQuestionTitle(questionConstant.getQuestionTitle());
        question.setQuestionBody(questionConstant.getQuestionBody());
        question.setMediaUrl(questionConstant.getMediaUrl());
        question.setScore(questionConstant.getScore());
//        question.setDurationSec(questionConstant.getDurationSec());
        return questionRepository.save(question);
    }

}
