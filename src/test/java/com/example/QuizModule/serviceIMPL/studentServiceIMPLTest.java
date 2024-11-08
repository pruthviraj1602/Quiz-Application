package com.example.QuizModule.serviceIMPL;


import com.example.QuizModule.Repository.studentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class studentServiceIMPLTest {

    @Autowired
    private studentRepo studentRepo;


    @Test
    public void testFindById(){
        Assertions.assertNotNull(studentRepo.getStudentByStudentId(10));
    }

}
