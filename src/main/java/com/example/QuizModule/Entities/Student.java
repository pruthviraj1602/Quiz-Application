package com.example.QuizModule.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    @Column(unique = true)
    private String studentUserName;
    private String studentPassword;
    private String Role;
}
