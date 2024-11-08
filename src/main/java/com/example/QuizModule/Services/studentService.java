package com.example.QuizModule.Services;

import com.example.QuizModule.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public interface studentService {



    public Student saveStudent(Student student);

    public Student getStudent(Integer studentId);

    public List<Student> getAllStudent();

    public Integer deleteStudent(Integer studentId);
}
