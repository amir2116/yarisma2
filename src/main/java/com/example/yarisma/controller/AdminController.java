package com.example.yarisma.controller;

import com.example.yarisma.model.CurrentData;
import com.example.yarisma.model.dto.ResponseDto;
import com.example.yarisma.model.entity.Question;
import com.example.yarisma.model.entity.Team;
import com.example.yarisma.service.QuestionService;
import com.example.yarisma.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final TeamService teamService;
    private final QuestionService questionService;
    private final SimpMessageSendingOperations messagingTemplate;

    @PutMapping("/team/{id}/score/increase/{value}")
    public ResponseEntity<ResponseDto> increaseScore(@PathVariable Integer id, @PathVariable int value) {
        Team team = teamService.increaseScore(id, value);
        messagingTemplate.convertAndSend("/topic/score", teamService.getAllTeamScores());
        return ResponseEntity.ok(new ResponseDto("SCORE_UPDATED"));
    }

    @PutMapping("/team/{id}/score/deccrease/{value}")
    public ResponseEntity<ResponseDto> decreaseScore(@PathVariable Integer id, @PathVariable int value) {
        teamService.decreaseScore(id, value);
        messagingTemplate.convertAndSend("/topic/score", teamService.getAllTeamScores());
        return ResponseEntity.ok(new ResponseDto("SCORE_UPDATED"));
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getById(id);
        messagingTemplate.convertAndSend("/topic/question", question); // fixed topic path
        return ResponseEntity.ok(question);
    }

    @PutMapping("/question/{questionId}/authorize/{teamId}")
    public ResponseEntity<ResponseDto> authorizeQuestion(@PathVariable Long questionId, @PathVariable Long teamId) {
        questionService.authorizeQuestion(questionId, teamId);
        return ResponseEntity.ok(new ResponseDto("AUTHORIZED"));
    }

    @GetMapping("/question/congratulation")
    public ResponseEntity<ResponseDto> sendCongratulation() {
        messagingTemplate.convertAndSend("/topic/feedback", "CONGRATULATION");
        return ResponseEntity.ok(new ResponseDto("CONGRATULATION_SENT"));
    }

    @GetMapping("/question/failure")
    public ResponseEntity<ResponseDto> sendFailure() {
        messagingTemplate.convertAndSend("/topic/feedback", "FAILURE");
        return ResponseEntity.ok(new ResponseDto("FAILURE_SENT"));
    }

    @PostMapping("/broadcast/data")
    public ResponseEntity<ResponseDto> sendCurrentData(@RequestBody CurrentData<?> data) {
        messagingTemplate.convertAndSend("/topic/data", data);
        return ResponseEntity.ok(new ResponseDto("DATA_BROADCASTED"));
    }
}
