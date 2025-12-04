package com.example.yarisma.model.entity;

import com.example.yarisma.model.enums.TeamColor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Team {
//    @Value()
    @Id()
    long id;

    @Column(unique = true)
    String name;

    @Column(length = 100)
    TeamColor color;

    @Column(length = 100)
    int score;

    public Team(long id) {
        this.id = id;
    }
}
