package com.example.QuizModule.Repository;

import com.example.QuizModule.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface questionRepository extends JpaRepository<Question,Integer> {

//    @Query(value = "SELECT * FROM question WHERE question_category = :question_category ORDER BY RAND() LIMIT 5", nativeQuery = true)
//    List<Question> findRandomQuestionByCategory(@Param("question_category") String category);

    @Query(value = "SELECT * FROM question WHERE question_category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category,@Param("numQ") int numQ);

    public List<Question> getQuestionByQuestionCategory(String questionCategory);
}
