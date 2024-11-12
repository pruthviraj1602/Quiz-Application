package com.example.QuizModule.Services;

import com.example.QuizModule.Entities.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface quizService {

    public Quiz createQuiz(createQuiz createQuiz);

//    public List<Question> startQuiz(Integer id);
public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id);
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
