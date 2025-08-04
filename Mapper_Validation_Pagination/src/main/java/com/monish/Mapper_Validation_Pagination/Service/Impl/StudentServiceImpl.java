package com.monish.Mapper_Validation_Pagination.Service.Impl;

import com.monish.Mapper_Validation_Pagination.Dto.StudentDto;
import com.monish.Mapper_Validation_Pagination.Entity.Student;
import com.monish.Mapper_Validation_Pagination.Repository.StudentRepo;
import com.monish.Mapper_Validation_Pagination.Service.StudentService;
import com.monish.Mapper_Validation_Pagination.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo repo;
    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student= Mapper.mapToStudent(studentDto);
        repo.save(student);
        return Mapper.mapTOStudentDto(student);
    }

    @Override
    public List<StudentDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        //Just to add pagenumber and pagesize
        //Pageable page = PageRequest.of(pageNumber,pageSize);
        //adding sorting using direction of sorting by default
        //Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        //adding sorting using direction of sorting by developers choice
        //Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy).descending());
        //adding sorting direction by client choice
        Sort sort=null;
        if(sortDir.equalsIgnoreCase("asc")){
            sort=Sort.by(sortBy).ascending();
        }else {
            sort=Sort.by(sortBy).descending();
        }
        Pageable page = PageRequest.of(pageNumber,pageSize, sort);
        List<Student> student=repo.findAll(page).get().toList();
        List<StudentDto> studentDtos=new ArrayList<>();
        for(Student student1:student){
            StudentDto studentDto=Mapper.mapTOStudentDto(student1);
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }
}
