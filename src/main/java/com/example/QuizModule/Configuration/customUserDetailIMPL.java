package com.example.QuizModule.Configuration;

import com.example.QuizModule.Entities.Student;
import com.example.QuizModule.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class customUserDetailIMPL implements UserDetailsService {

    @Autowired
    private studentRepo studentRepo;

    @Override
    public UserDetails loadUserByUsername(String studentUserName) throws UsernameNotFoundException {
        Student student = studentRepo.getStudentByStudentUserName(studentUserName);
        System.out.println(student);
        if(student==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new customUserDetail(student);
    }
}
