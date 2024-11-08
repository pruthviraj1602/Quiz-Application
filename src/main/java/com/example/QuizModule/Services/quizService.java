package com.example.QuizModule.Services;

import com.example.QuizModule.Entities.Question;
import com.example.QuizModule.Entities.Response;
import com.example.QuizModule.Entities.questionWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface quizService {

    public ResponseEntity<String> createQuiz(String category, int numQ, String tittle);

//    public List<Question> startQuiz(Integer id);
public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id);
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
