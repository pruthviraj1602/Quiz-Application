package com.example.QuizModule.Entities;

import lombok.Data;

@Data
public class jwtResponse {

    private String token;

    public jwtResponse(String token) {
        this.token = token;
    }
}
