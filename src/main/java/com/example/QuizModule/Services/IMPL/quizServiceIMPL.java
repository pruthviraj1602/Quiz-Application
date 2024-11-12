package com.example.QuizModule.Services.IMPL;

import com.example.QuizModule.Entities.*;
import com.example.QuizModule.Repository.QuizRepository;
import com.example.QuizModule.Repository.questionRepository;
import com.example.QuizModule.Services.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class quizServiceIMPL implements quizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private questionRepository questionRepository;


    @Override
    public Quiz createQuiz(createQuiz createquiz) {

        List<Question> questions=questionRepository.findRandomQuestionsByCategory(createquiz.getCategory(),createquiz.getNumQ());

        Quiz quiz=new Quiz();
        quiz.setTittle(createquiz.getTittle());
        quiz.setQuestions(questions);

        return quizRepository.save(quiz);
    }



    @Override
    public ResponseEntity<List<questionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quizId = quizRepository.findById(id);
        List<Question> questionsDB = quizId.get().getQuestions();
        List<questionWrapper> questionUSER=new ArrayList<>();
        for(Question q:questionsDB){
            questionWrapper qw=new questionWrapper(q.getId(),q.getQuestionName(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionUSER.add(qw);
        }

        return new ResponseEntity<>(questionUSER,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizRepository.getQuizById(id);
        List<Question> questions=quiz.getQuestions(); //get the question from the db

        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getCorrectOption())) //match the question and the response here.
                right++;

            i++;
        }

        return new ResponseEntity<>(right,HttpStatus.CREATED);
    }


}
