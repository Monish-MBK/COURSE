package com.monish.Mapper_Validation_Pagination.Service;

import com.monish.Mapper_Validation_Pagination.Dto.StudentDto;

import java.util.List;


public interface StudentService {
    StudentDto addStudent(StudentDto studentDto);

    List<StudentDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);
}
