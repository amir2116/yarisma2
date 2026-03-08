package com.example.yarisma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/button")
public class ButtonController {

    @GetMapping("/button")
    public synchronized ResponseEntity<LocalTime>  getDate(){
        DateTimeFormatter  dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalTime time = LocalTime.now();
        time.format(dtf);
        return ResponseEntity.ok(time);
    }

}
