package com.example.yarisma.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionConstant {

    QUESTION_1(
            1L
//        ,"ROUND_1"
            ,QuestionType.TEXT,
            "Q1", "Which movie won the Oscar for Best Picture in 1994?",
            null, 10
//        , 30
    ),

    QUESTION_2(
            2L
//        ,"ROUND_1"
            ,QuestionType.IMAGE,
            "Q2", "Which movie is this scene from?",
            "/images/q2_scene.jpg", 10
//        , 30
    ),

    QUESTION_3(
            3L
//        ,"ROUND_1"
            ,QuestionType.AUDIO,
            "Q3", "Which movie does this OST belong to?",
            "/audio/q3_ost.mp3", 15
//        , 30
    ),

    QUESTION_4(
            4L
//        ,"ROUND_1"
            ,QuestionType.TEXT,
            "Q4", "Who directed the movie 'Inception'?",
            null, 10
//        , 25
    ),

    QUESTION_5(
            5L
//        ,"ROUND_1"
            ,QuestionType.IMAGE,
            "Q5", "Identify this actor.",
            "/images/q5_actor.jpg", 10
//        , 25
    ),

    QUESTION_6(
            6L
//        ,"ROUND_1"
            ,QuestionType.AUDIO,
            "Q6", "Which film is this soundtrack from?",
            "/audio/q6.mp3", 15
//        , 30
    ),

    QUESTION_7(
            7L
//        ,"ROUND_2"
            ,QuestionType.TEXT,
            "Q7", "Which movie features the quote: 'I'll be back'?",
            null, 10
//        , 25
    ),

    QUESTION_8(
            8L
//        ,"ROUND_2"
            ,QuestionType.IMAGE,
            "Q8", "Name this movie poster.",
            "/images/q8.jpg", 10
//        , 25
    ),

    QUESTION_9(
            9L
//        ,"ROUND_2"
            ,QuestionType.AUDIO,
            "Q9", "Which movie theme is playing?",
            "/audio/q9.mp3", 15
//        , 30
    ),

    QUESTION_10(
            10L
//        ,"ROUND_2"
            ,QuestionType.TEXT,
            "Q10", "Which movie holds the record for highest box office?",
            null, 10
//        , 25
    ),

    QUESTION_11(
            11L
//        ,"ROUND_2"
            ,QuestionType.IMAGE,
            "Q11", "Which film is this frame from?",
            "/images/q11.jpg", 10
//        , 25
    ),

    QUESTION_12(
            12L
//        ,"ROUND_2"
            ,QuestionType.AUDIO,
            "Q12", "Guess the movie by its intro music.",
            "/audio/q12.mp3", 15
//        , 30
    ),

    QUESTION_13(
            13L
//        ,"ROUND_3"
            ,QuestionType.TEXT,
            "Q13", "Which actor played Joker in The Dark Knight?",
            null, 10
//        , 25
    ),

    QUESTION_14(
            14L
//        ,"ROUND_3"
            ,QuestionType.IMAGE,
            "Q14", "Which movie is this location from?",
            "/images/q14.jpg", 10
//        , 25
    ),

    QUESTION_15(
            15L
//        ,"ROUND_3"
            ,QuestionType.AUDIO,
            "Q15", "Identify this movie soundtrack.",
            "/audio/q15.mp3", 15
//        , 30
    ),

    QUESTION_16(
            16L
//        ,"ROUND_3"
            ,QuestionType.TEXT,
            "Q16", "Which movie is known as the first full-length animated film?",
            null, 10
//        , 25
    ),

    QUESTION_17(
            17L
//        ,"ROUND_3"
            ,QuestionType.IMAGE,
            "Q17", "Whose character is this?",
            "/images/q17.jpg", 10
//        , 25
    ),

    QUESTION_18(
            18L
//        ,"ROUND_3"
            ,QuestionType.AUDIO,
            "Q18", "Which film is this OST from?",
            "/audio/q18.mp3", 15
//        , 30
    ),

    QUESTION_19(
            19L
//        ,"ROUND_4"
            ,QuestionType.TEXT,
            "Q19", "Which movie won most Oscars ever?",
            null, 15
//        , 30
    ),

    QUESTION_20(
            20L
//        ,"ROUND_4"
            ,QuestionType.IMAGE,
            "Q20", "Name this horror movie scene.",
            "/images/q20.jpg", 15
//        , 30
    ),

    QUESTION_21(
            21L
//        ,"ROUND_4"
            ,QuestionType.AUDIO,
            "Q21", "Which thriller movie soundtrack is this?",
            "/audio/q21.mp3", 15
//        , 30
    ),

    QUESTION_22(
            22L
//        ,"ROUND_4"
            ,QuestionType.TEXT,
            "Q22", "Who composed the music for Interstellar?",
            null, 15
//        , 25
    ),

    QUESTION_23(
            23L
//        ,"ROUND_4"
            ,QuestionType.IMAGE,
            "Q23", "Which movie logo is this?",
            "/images/q23.jpg", 15
//        , 25
    ),

    QUESTION_24(
            24L
//        ,"ROUND_4"
            ,QuestionType.AUDIO,
            "Q24", "Guess the movie by soundtrack.",
            "/audio/q24.mp3", 15
//        , 30
    ),

    QUESTION_25(
            25L
//        ,"ROUND_5"
            ,QuestionType.TEXT,
            "Q25", "Which movie is known for the quote 'Why so serious?'",
            null, 20
//        , 30
    ),

    QUESTION_26(
            26L
//        ,"ROUND_5"
            ,QuestionType.IMAGE,
            "Q26", "Name this sci-fi movie scene.",
            "/images/q26.jpg", 20
//        , 30
    ),

    QUESTION_27(
            27L
//        ,"ROUND_5"
            ,QuestionType.AUDIO,
            "Q27", "Which epic movie score is this?",
            "/audio/q27.mp3", 20
//        , 30
    ),

    QUESTION_28(
            28L
//        ,"ROUND_5"
            ,QuestionType.TEXT,
            "Q28", "Which movie introduced the character Darth Vader?",
            null, 20
//        , 25
    ),

    QUESTION_29(
            29L
//        ,"ROUND_5"
            ,QuestionType.IMAGE,
            "Q29", "Which movie is this character from?",
            "/images/q29.jpg", 20
//        , 25
    ),

    QUESTION_30(
            30L
//        ,"ROUND_5"
            ,QuestionType.AUDIO,
            "Q30", "Guess this legendary soundtrack.",
            "/audio/q30.mp3", 20
//        , 30
    ),

    QUESTION_31(
            31L
//        ,"FINAL"
            ,QuestionType.TEXT,
            "Q31", "Which film is often considered the greatest of all time?",
            null, 25
//        , 30
    ),

    QUESTION_32(
            32L
//        ,"FINAL"
            ,QuestionType.IMAGE,
            "Q32", "Which movie does this final scene belong to?",
            "/images/q32.jpg", 25
//        , 30
    ),

    QUESTION_33(
            33L
//        ,"FINAL"
            ,QuestionType.AUDIO,
            "Q33", "Guess the final soundtrack.",
            "/audio/q33.mp3", 30
//        , 40
    ),

    QUESTION_34(
            34L
//        ,"FINAL"
            ,QuestionType.TEXT,
            "Q34", "Which director won 3 Oscars for Best Director?",
            null, 25
//        , 30
    ),

    QUESTION_35(
            35L
//        ,"FINAL"
            ,QuestionType.IMAGE,
            "Q35", "Identify this famous movie shot.",
            "/images/q35.jpg", 25
//        , 30
    ),

    QUESTION_36(
            36L
//        ,"FINAL"
            ,QuestionType.AUDIO,
            "Q36", "Which movie theme is this?",
            "/audio/q36.mp3", 30
//        , 40
    ),

    QUESTION_37(
            37L
//        ,"BONUS"
            ,QuestionType.TEXT,
            "Q37", "Which movie is entirely in black and white?",
            null, 10
//        , 20
    ),

    QUESTION_38(
            38L
//        ,"BONUS"
            ,QuestionType.IMAGE,
            "Q38", "Which animated film is this?",
            "/images/q38.jpg", 10
//        , 20
    ),

    QUESTION_39(
            39L
//        ,"BONUS"
            ,QuestionType.AUDIO,
            "Q39", "Name this animated movie OST.",
            "/audio/q39.mp3", 15
//        , 25
    ),

    QUESTION_40(
            40L
//        ,"BONUS"
            ,QuestionType.TEXT,
            "Q40", "Which movie has the longest runtime ever?",
            null, 15
//        , 25
    ),

    QUESTION_41(
            41L
//        ,"BONUS"
            ,QuestionType.IMAGE,
            "Q41", "Which superhero movie is this?",
            "/images/q41.jpg", 15
//        , 25
    ),

    QUESTION_42(
            42L
//        ,"BONUS"
            ,QuestionType.AUDIO,
            "Q42", "Which action movie soundtrack is this?",
            "/audio/q42.mp3", 15
//        , 25
    ),

    QUESTION_43(
            43L
//        ,"EXTRA"
            ,QuestionType.TEXT,
            "Q43", "Which movie popularized the bullet-time effect?",
            null, 20
//        , 30
    ),

    QUESTION_44(
            44L
//        ,"EXTRA"
            ,QuestionType.IMAGE,
            "Q44", "Which movie does this villain belong to?",
            "/images/q44.jpg", 20
//        , 30
    ),

    QUESTION_45(
            45L
//        ,"EXTRA"
            ,QuestionType.AUDIO,
            "Q45", "Which fantasy movie soundtrack is this?",
            "/audio/q45.mp3", 25
//        , 40
    ),

    QUESTION_46(
            46L
//        ,"EXTRA"
            ,QuestionType.TEXT,
            "Q46", "Which movie features time travel in a DeLorean?",
            null, 20
//        , 25
    ),

    QUESTION_47(
            47L
//        ,"EXTRA"
            ,QuestionType.IMAGE,
            "Q47", "Identify this classic movie scene.",
            "/images/q47.jpg", 20
//        , 25
    ),

    QUESTION_48(
            48L
//        ,"EXTRA"
            ,QuestionType.AUDIO,
            "Q48", "Which classic film is this music from?",
            "/audio/q48.mp3", 25
//        , 35
    ),

    QUESTION_49(
            49L
//        ,"MEGA"
            ,QuestionType.TEXT,
            "Q49", "Which is the most award-winning movie in history?",
            null, 30
//        , 40
    ),

    QUESTION_50(
            50L
//        ,"MEGA"
            ,QuestionType.IMAGE,
            "Q50", "Final challenge – which movie is this?",
            "/images/q50.jpg", 40
//        , 45
    );



    private final Long id;

//    private final String questionTab;

    private final QuestionType questionType;

    private final String questionTitle;

    private final String questionBody;

    private final String mediaUrl;

    private final Integer score;

//    private final Integer durationSec;
}
