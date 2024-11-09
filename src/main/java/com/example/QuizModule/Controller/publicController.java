package com.example.QuizModule.Controller;

import com.example.QuizModule.Configuration.customUserDetailIMPL;
import com.example.QuizModule.Entities.Student;
import com.example.QuizModule.Entities.jwtRequest;
import com.example.QuizModule.Entities.jwtResponse;
import com.example.QuizModule.Repository.studentRepo;
import com.example.QuizModule.Services.IMPL.studentServiceIMPL;
import com.example.QuizModule.jwt.jwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
@CrossOrigin("*")
public class publicController {

    @Autowired
    private studentServiceIMPL studentServiceIMPL;

    @Autowired
    private studentRepo  studentRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private customUserDetailIMPL customUserDetailIMPL;

    @Autowired
    private jwtUtils jwtUtils;


    @PostMapping("/register-student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        student.setRole("ROLE_USER");
        Student student1 = studentServiceIMPL.saveStudent(student);
        if(student1!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(student1);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody jwtRequest request) {
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getStudentUserName(), request.getStudentPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect Username Password");
        }

        UserDetails userDetails = customUserDetailIMPL.loadUserByUsername(request.getStudentUserName());
        Student student = studentRepo.getStudentByStudentUserName(userDetails.getUsername());
        String jwt = null;
        if (authenticate.isAuthenticated()) {
            jwt = jwtUtils.generateToken(userDetails.getUsername());
        }
        if (jwt != null) {
           return ResponseEntity.status(HttpStatus.OK).body(jwt);
        }
        return null;
    }

}
