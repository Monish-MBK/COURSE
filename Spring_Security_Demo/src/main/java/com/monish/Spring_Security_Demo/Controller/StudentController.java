package com.monish.Spring_Security_Demo.Controller;

import com.monish.Spring_Security_Demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Virat","Cover Drive"),
            new Student(2,"ABD","360 Shots"),
            new Student(3,"Chris","Big Hitter")
    ));
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getALlStudents(){
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    //For put post and delete we need CSRF token to access the methods even after login
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(students.add(student),HttpStatus.CREATED);
    }
    //Now creating a method to get CSRF token which will be provided by the spring security
    //This method is same for all other projects also
    @GetMapping("/CSRF-Token")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    //We cannot pass csrf token in a  webpage so we will create our own configuration of security in the config class
//    @DeleteMapping("/delete/{rollno}")
//    public String deleteStudent(@PathVariable int rollno){
//        if(rollno == students.getFirst().getRollno()){
//            students.remove(deleteStudent(rollno));
//        }
//        return "deleted";
//    }
}
