package com.monish.Mapper_Validation_Pagination.Util;

import com.monish.Mapper_Validation_Pagination.Dto.StudentDto;
import com.monish.Mapper_Validation_Pagination.Entity.Student;
import com.monish.Mapper_Validation_Pagination.MapperValidationPaginationApplication;

import java.util.List;

public class Mapper {
    public static StudentDto mapTOStudentDto(Student student){
        return MapperValidationPaginationApplication.modelMapper().map(student, StudentDto.class);
    }

    public static Student mapToStudent(StudentDto studentDto){
        return MapperValidationPaginationApplication.modelMapper().map(studentDto, Student.class);
    }
}
