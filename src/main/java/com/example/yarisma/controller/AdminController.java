package com.example.yarisma.controller;

import com.example.yarisma.model.dto.ResponseDto;
import com.example.yarisma.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TeamService teamService;


    @PutMapping("/team/{id}/score/increase/{value}")
    public ResponseEntity<ResponseDto> increaseScore(
            @PathVariable Integer id,
            @PathVariable int i) {
        teamService.increaseScore(id,i);
        return ResponseEntity.ok(new ResponseDto("CREATED"));
    }

    @PutMapping("/team/{id}/score/deccrease/{value}")
    public ResponseEntity<ResponseDto> decreaseScore(
            @PathVariable Integer id,
            @PathVariable int value
){
        teamService.decreaseScore(id,value);
        return ResponseEntity.ok(new ResponseDto("CREATED"));
    }


}
