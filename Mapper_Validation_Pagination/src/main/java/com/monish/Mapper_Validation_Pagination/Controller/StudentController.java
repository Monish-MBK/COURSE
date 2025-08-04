package com.monish.Mapper_Validation_Pagination.Controller;

import com.monish.Mapper_Validation_Pagination.Dto.StudentDto;
import com.monish.Mapper_Validation_Pagination.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<StudentDto> add(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.CREATED);
    }
    //http://localhost:8080/api/student/getall?pageNumber=0&pageSize=10&sortBy=marks&sortDir=dsc
    @GetMapping("/getall")
    public ResponseEntity<List<StudentDto>> getAll(@RequestParam(defaultValue = "0",required = false) int pageNumber,
                                                   @RequestParam(defaultValue = "5",required = false) int pageSize,
                                                   @RequestParam(defaultValue = "rollno",required = false)String sortBy,
                                                   @RequestParam(defaultValue = "asc",required = false)String sortDir){
        return new ResponseEntity<>(studentService.getAll(pageNumber, pageSize,sortBy,sortDir),HttpStatus.OK);
    }
}
