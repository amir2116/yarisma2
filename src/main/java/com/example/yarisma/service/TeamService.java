package com.example.yarisma.service;


import com.example.yarisma.model.entity.Team;
import com.example.yarisma.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;


    public void increaseScore(Integer id, int i) {
        Team team = teamRepository.findById(id).get();
        team.setScore(team.getScore() + i);
        teamRepository.save(team);
    }

    public void decreaseScore(Integer id, int i) {
        Team team = teamRepository.findById(id).get();
        team.setScore(team.getScore() - i);
        teamRepository.save(team);
    }
}
