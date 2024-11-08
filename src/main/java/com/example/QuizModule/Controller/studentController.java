package com.example.QuizModule.Controller;

import com.example.QuizModule.Entities.Question;
import com.example.QuizModule.Entities.Response;
import com.example.QuizModule.Entities.questionWrapper;
import com.example.QuizModule.Services.IMPL.questionServiceIMPL;
import com.example.QuizModule.Services.IMPL.quizServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class studentController {

    @Autowired
    private questionServiceIMPL questionServiceIMPL;

    @Autowired
    private quizServiceIMPL quizServiceIMPL;


    @GetMapping("/getQuestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> allQuestions = questionServiceIMPL.getAllQuestions();
        if(allQuestions!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(allQuestions);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<questionWrapper>> startQuiz(@PathVariable Integer id){
      return quizServiceIMPL.getQuizQuestion(id);
    }

    @PostMapping("/submitAnswer/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        System.out.println(responses); //get the response here and match with the
        return quizServiceIMPL.calculateResult(id,responses);
    }
}
