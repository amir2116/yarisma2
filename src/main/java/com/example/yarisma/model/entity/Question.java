package com.example.yarisma.model.entity;
import com.example.yarisma.model.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    @Id
    private Long id;
//
//    @Column(length = 100)
//    private String questionTab;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Column
    private String questionTitle;

    @Column(columnDefinition = "TEXT")
    private String questionBody;

    @Column
    private String mediaUrl;

    @Column
    private Integer score;

//    @Column
//    private Integer durationSec;

    @ManyToOne
    private Team answeredTeam;

    public Question(Long id) {
        this.id = id;
    }
}
