package com.example.yarisma.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/button")
public class ButtonController {

    @GetMapping("button")
    public synchronized ResponseEntity<LocalDate>  getDate(){
        LocalDate date = LocalDate.now();
        return ResponseEntity.ok(date);
    }

}
