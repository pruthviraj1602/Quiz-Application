package com.example.QuizModule.Controller;

import com.example.QuizModule.Entities.Question;
import com.example.QuizModule.Entities.Student;
import com.example.QuizModule.Services.IMPL.questionServiceIMPL;
import com.example.QuizModule.Services.IMPL.quizServiceIMPL;
import com.example.QuizModule.Services.IMPL.studentServiceIMPL;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class adminController {

    @Autowired
    private studentServiceIMPL studentServiceIMPL;

    @Autowired
    private questionServiceIMPL questionServiceIMPL;

    @Autowired
    private quizServiceIMPL quizServiceIMPL;


    @PostConstruct
    public void saveAdmin(){
        Student student =new Student();
        student.setStudentId(1);
        student.setStudentUserName("admin12@gmail.com");
        student.setStudentPassword("12345");
        student.setRole("ROLE_ADMIN");
        studentServiceIMPL.saveStudent(student);
    }

    @PostMapping("/add-question")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question question1 = questionServiceIMPL.addQuestion(question);
        if(question1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(question1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getQuestionByCat")
    public ResponseEntity<List<Question>> getQuestion(@RequestBody Question question){
        String questionCategory = question.getQuestionCategory();
        List<Question> questionByCategory = questionServiceIMPL.getQuestionByCategory(questionCategory);
        if(questionByCategory!=null){
            return ResponseEntity.status(HttpStatus.OK).body(questionByCategory);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer studentId){
        Student ID = studentServiceIMPL.getStudent(studentId);
        if(ID!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(ID);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = studentServiceIMPL.getAllStudent();
        if(students!=null){
            return ResponseEntity.status(HttpStatus.OK).body(students);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId){
        Integer i = studentServiceIMPL.deleteStudent(studentId);
        if(i!=null){
           return ResponseEntity.status(HttpStatus.OK).body("Student Deleted Successfully..");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Not Deleted....");
    }

    //Generate Quiz
    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String tittle){
       return quizServiceIMPL.createQuiz(category,numQ,tittle);
//        System.out.println(category+" "+numQ+" "+tittle);
    }

}
