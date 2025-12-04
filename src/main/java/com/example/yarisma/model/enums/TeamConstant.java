package com.example.yarisma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.example.yarisma.model.enums.TeamColor.*;

@RequiredArgsConstructor
@Getter
public enum TeamConstant {

    TEAM1(1l,"team1",GREEN),
    TEAM2(2l,"team2",RED),
    TEAM3(3l,"team3",YELLOW),
    TEAM4(4l,"team4",BLUE),;

    private final long id;
    private final String name;
    private final TeamColor color;

}
