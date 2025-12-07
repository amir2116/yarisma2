package com.example.yarisma.model;

import com.example.yarisma.model.entity.Question;
import com.example.yarisma.model.entity.Team;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentData<T> {

    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;

    private Question question;
}
