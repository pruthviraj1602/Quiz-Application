package com.example.QuizModule.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String questionName;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctOption;
    private String questionCategory;

}
