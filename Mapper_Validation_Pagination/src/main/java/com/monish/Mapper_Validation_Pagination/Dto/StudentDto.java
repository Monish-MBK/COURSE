package com.monish.Mapper_Validation_Pagination.Dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class StudentDto {
    private int rollno;
    @NotNull
    @NotEmpty
    @Size(min = 3,message = "Name should be more than 3 letters")
    @Size(max = 12,message = "Name should be less than 12 letters")
    private String name;
    @NotNull
    @Min(value = 0,message = "Marks must be greater than 0")
    @Max(value = 100,message = "Marks must be less than 100")
    private int marks;

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public StudentDto(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;
    }

    public StudentDto() {
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
