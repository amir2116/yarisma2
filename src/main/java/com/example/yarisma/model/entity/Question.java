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
@AllArgsConstructor
@Builder
public class Question {

    @Id
    private Long id;

    private String questionTab;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    private String questionTitle;

    @Column(columnDefinition = "TEXT")
    private String questionBody;

    private String mediaUrl;

    private Integer score;

    private Integer durationSec;

}
