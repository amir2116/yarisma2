package com.example.yarisma.model.enums;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

public enum Questions {

    QUESTION_1,
    QUESTION_2,
    QUESTION_3,
    QUESTION_4,
    QUESTION_5,
    QUESTION_6,
    QUESTION_7,
    QUESTION_8,
    QUESTION_9,
    QUESTION_10,
    QUESTION_11,
    QUESTION_12,
    QUESTION_13,
    QUESTION_14,
    QUESTION_15,
    QUESTION_16,
    QUESTION_17,
    QUESTION_18,
    QUESTION_19,
    QUESTION_20,
    QUESTION_21,
    QUESTION_22,
    QUESTION_23,
    QUESTION_24,
    QUESTION_25,
    QUESTION_26,
    QUESTION_27,
    QUESTION_28,
    QUESTION_29,
    QUESTION_30,
    QUESTION_31,
    QUESTION_32,
    QUESTION_33,
    QUESTION_34,
    QUESTION_35,
    QUESTION_36,
    QUESTION_37,
    QUESTION_38,
    QUESTION_39,
    QUESTION_40,
    QUESTION_41,
    QUESTION_42,
    QUESTION_43,
    QUESTION_44,
    QUESTION_45,
    QUESTION_46,
    QUESTION_47,
    QUESTION_48,
    QUESTION_49,
    QUESTION_50;


    private Long id;

    private String questionTab;

    private QuestionType questionType;

    private String questionTitle;

    private String questionBody;

    private String mediaUrl;

    private Integer score;

    private Integer durationSec;
}
