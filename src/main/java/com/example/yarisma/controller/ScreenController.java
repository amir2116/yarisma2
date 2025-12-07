package com.example.yarisma.controller;

import com.example.yarisma.model.CurrentData;
import com.example.yarisma.service.TeamService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    TeamService teamService;

    @GetMapping("/current")
    public ResponseEntity<CurrentData> current() {
        return ResponseEntity.ok(CurrentData.builder()
                        .team1(teamService.getById(1))
                        .team2(teamService.getById(2))
                        .team3(teamService.getById(3))
                        .team4(teamService.getById(4))
//                        .question()
                .build());
    }

}
