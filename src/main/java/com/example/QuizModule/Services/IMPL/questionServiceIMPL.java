package com.example.QuizModule.Services.IMPL;

import com.example.QuizModule.Entities.Question;
import com.example.QuizModule.Repository.questionRepository;
import com.example.QuizModule.Services.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionServiceIMPL implements questionService {

    @Autowired
    private questionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> getQuestionByCategory(String questionCategory) {
        return questionRepository.getQuestionByQuestionCategory(questionCategory);
    }
}
