package com.example.yarisma.config;

import com.example.yarisma.model.entity.Team;
import static com.example.yarisma.model.enums.TeamConstant.*;

import com.example.yarisma.model.enums.TeamConstant;
import com.example.yarisma.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Configurations {
    @Bean
    public CommandLineRunner commandLineRunner(TeamRepository teamRepository) {
        return args -> teamRepository.saveAll(
               List.of(
                        updateTeam(teamRepository,TEAM1),
                        updateTeam(teamRepository,TEAM2),
                        updateTeam(teamRepository,TEAM3),
                        updateTeam(teamRepository,TEAM4)
                )
        );
    }

    public Team updateTeam(TeamRepository teamRepository, TeamConstant teamConstant) {
        Team team= teamRepository.findById(teamConstant.getId()).orElse(new Team(teamConstant.getId()));
        team.setName(teamConstant.getName());
        team.setColor(teamConstant.getColor());
        return team;

    }

}
