package com.example.QuizModule.Entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;

@Data
@RequiredArgsConstructor
public class Response {

    private Integer id;
    private String response;
}
