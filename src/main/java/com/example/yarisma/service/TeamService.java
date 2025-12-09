package com.example.yarisma.service;


import com.example.yarisma.model.entity.Team;
import com.example.yarisma.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;


    public Team increaseScore(Integer id, int i) {
        Team team = teamRepository.findById(id).get();
        team.setScore(team.getScore() + i);
        return teamRepository.save(team);
    }

    public void decreaseScore(Integer id, int i) {
        Team team = teamRepository.findById(id).get();
        team.setScore(team.getScore() - i);
        teamRepository.save(team);
    }

    public Team getById(int i) {
        return teamRepository.findById(i).get();
    }

    public Map<Long,Integer> getAllTeamScores() {
        Map<Long, Integer> scores = new HashMap<>();
        for(int id=1;id<=4;id++){
            teamRepository.findById(id).ifPresent(team -> {scores.put(team.getId(), team.getScore());});
        }
        return scores;
    }
}
