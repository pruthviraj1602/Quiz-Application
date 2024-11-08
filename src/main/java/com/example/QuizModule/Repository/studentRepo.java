package com.example.QuizModule.Repository;

import com.example.QuizModule.Entities.Student;
import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;

public interface studentRepo extends JpaRepository<Student,Integer> {

    public Student getStudentByStudentId(Integer studentId);

    @Transactional
    public Integer deleteStudentByStudentId(Integer studentId);

    public Student getStudentByStudentUserName(String studentUserName);
}
