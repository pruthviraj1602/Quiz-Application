package com.example.QuizModule.Controller;

import com.example.QuizModule.Entities.Student;
import com.example.QuizModule.Services.IMPL.studentServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@CrossOrigin("*")
public class publicController {

    @Autowired
    private studentServiceIMPL studentServiceIMPL;


    @PostMapping("/register-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        student.setRole("ROLE_USER");
        Student student1 = studentServiceIMPL.saveStudent(student);
        if(student1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(student1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
