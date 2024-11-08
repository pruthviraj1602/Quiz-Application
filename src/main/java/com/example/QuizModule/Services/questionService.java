package com.example.QuizModule.Services;

import com.example.QuizModule.Entities.Question;

import java.util.List;

public interface questionService {

    public Question addQuestion(Question question);

    public List<Question> getAllQuestions();

    public List<Question> getQuestionByCategory(String questionCategory);
}
