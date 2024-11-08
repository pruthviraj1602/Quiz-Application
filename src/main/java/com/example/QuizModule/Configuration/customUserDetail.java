package com.example.QuizModule.Configuration;

import com.example.QuizModule.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class customUserDetail implements UserDetails {

    @Autowired
    private Student student;

    public customUserDetail(Student student){
        super();
        this.student=student;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = student.getRole();
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(role);
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return student.getStudentPassword();
    }

    @Override
    public String getUsername() {
        return student.getStudentUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
