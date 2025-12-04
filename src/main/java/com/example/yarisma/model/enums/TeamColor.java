package com.example.yarisma.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TeamColor {
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    GREEN("green"),
    CYAN("cyan"),
    PURPLE("purple"),
    BLACK("black"),
    WHITE("white");

    private final String color;



}
