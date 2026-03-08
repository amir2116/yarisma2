package com.example.yarisma.controller;

import com.example.yarisma.model.CurrentData;
import com.example.yarisma.model.dto.ResponseDto;
import com.example.yarisma.model.entity.Question;
import com.example.yarisma.model.entity.Team;
import com.example.yarisma.service.QuestionService;
import com.example.yarisma.service.TeamService;
import lombok.RequiredArgsConstructor;
import com.example.yarisma.config.BuzzerHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final TeamService teamService;
    private final QuestionService questionService;
    private final SimpMessageSendingOperations messagingTemplate;
    private final BuzzerHandler buzzerHandler;

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
        messagingTemplate.convertAndSend("/topic/question", question);
        return ResponseEntity.ok(question);
    }

    @PutMapping("/question/{questionId}/authorize/{teamId}")
    public ResponseEntity<ResponseDto> authorizeQuestion(@PathVariable Long questionId, @PathVariable Long teamId) {
        questionService.authorizeQuestion(questionId, teamId);
        return ResponseEntity.ok(new ResponseDto("AUTHORIZED"));
    }

    @PutMapping("/question/{questionId}/unauthorize")
    public ResponseEntity<ResponseDto> unauthorizeQuestion(@PathVariable Long questionId) {
        questionService.unauthorizeQuestion(questionId);
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

    @PostMapping("/screen/clear-buzz")
    public ResponseEntity<ResponseDto> clearScreenBuzz() {
        messagingTemplate.convertAndSend("/topic/feedback", "RESET");
        return ResponseEntity.ok(new ResponseDto("SCREEN_BUZZ_CLEARED"));
    }

    @PostMapping("/timer/display/clear")
    public ResponseEntity<ResponseDto> clearTimerDisplay() {
        messagingTemplate.convertAndSend("/topic/timer", 0);
        return ResponseEntity.ok(new ResponseDto("TIMER_DISPLAY_CLEARED"));
    }

    @PostMapping("/timer/display/{seconds}")
    public ResponseEntity<ResponseDto> updateTimerDisplay(@PathVariable int seconds) {
        messagingTemplate.convertAndSend("/topic/timer", Math.max(seconds, 0));
        return ResponseEntity.ok(new ResponseDto("TIMER_DISPLAY_UPDATED"));
    }

    @PostMapping("/buzzer/enable")
    public ResponseEntity<ResponseDto> enableBuzzers() {
        buzzerHandler.enableBuzzers();
        return ResponseEntity.ok(new ResponseDto("BUZZERS_ENABLED"));
    }

    @PostMapping("/buzzer/disable")
    public ResponseEntity<ResponseDto> disableBuzzers() throws IOException {
        buzzerHandler.disableBuzzers();
        return ResponseEntity.ok(new ResponseDto("BUZZERS_DISABLED"));
    }

    @PostMapping("/buzzer/reset")
    public ResponseEntity<ResponseDto> resetBuzzers() throws IOException {
        buzzerHandler.resetRound();
        return ResponseEntity.ok(new ResponseDto("BUZZERS_RESET"));
    }

    @PostMapping("/buzzer/team/{teamId}/enable")
    public ResponseEntity<ResponseDto> enableTeamBuzzer(@PathVariable int teamId) {
        buzzerHandler.enableTeam(teamId);
        return ResponseEntity.ok(new ResponseDto("TEAM_BUZZER_ENABLED"));
    }

    @PostMapping("/buzzer/team/{teamId}/disable")
    public ResponseEntity<ResponseDto> disableTeamBuzzer(@PathVariable int teamId) {
        buzzerHandler.disableTeam(teamId);
        return ResponseEntity.ok(new ResponseDto("TEAM_BUZZER_DISABLED"));
    }

    @PostMapping("/broadcast/data")
    public ResponseEntity<ResponseDto> sendCurrentData(@RequestBody CurrentData<?> data) {
        messagingTemplate.convertAndSend("/topic/data", data);
        return ResponseEntity.ok(new ResponseDto("DATA_BROADCASTED"));
    }
}
