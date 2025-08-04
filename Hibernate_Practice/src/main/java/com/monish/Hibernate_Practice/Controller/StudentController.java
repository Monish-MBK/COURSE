package com.monish.Hibernate_Practice.Controller;

import com.monish.Hibernate_Practice.Entity.Student;
import com.monish.Hibernate_Practice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Adding student detailes without image
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1=studentService.addStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }
    //Adding just image to existing student details
    @PutMapping("/addimage/{id}")
    public ResponseEntity<Student> addingImage(@PathVariable int id,@RequestPart MultipartFile image) throws IOException {
        Student student=studentService.addingImage(id,image);
        return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
    }
    //Adding details with image
    @PostMapping("/add/all")
    public ResponseEntity<Student> addAll(@RequestPart Student student,@RequestPart MultipartFile image) throws IOException {
        Student student1=studentService.allAll(student,image);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(studentService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getProductById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student.getId() > 0) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
