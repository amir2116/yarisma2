package com.example.yarisma.model.entity;

import com.example.yarisma.model.enums.TeamColor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.awt.*;

@Entity
public class Team {
//    @Value()
    @Id()
    String name;
    @Column(length = 100)
    TeamColor color;
    int score=0;

}
