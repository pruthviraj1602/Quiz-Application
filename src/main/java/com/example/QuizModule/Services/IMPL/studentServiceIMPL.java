package com.example.QuizModule.Services.IMPL;

import com.example.QuizModule.Entities.Student;
import com.example.QuizModule.Repository.studentRepo;

import com.example.QuizModule.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceIMPL implements studentService {

    @Autowired
    private studentRepo studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public Student saveStudent(Student student) {
        student.setStudentPassword(passwordEncoder().encode(student.getStudentPassword()));
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Integer studentId) {
        return studentRepository.getStudentByStudentId(studentId);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Integer deleteStudent(Integer studentId) {
        return studentRepository.deleteStudentByStudentId(studentId);
    }
}
