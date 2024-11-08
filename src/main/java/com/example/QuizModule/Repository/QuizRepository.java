package com.example.QuizModule.Repository;

import com.example.QuizModule.Entities.Question;
import com.example.QuizModule.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
   public Quiz getQuizById(Integer id);


}
