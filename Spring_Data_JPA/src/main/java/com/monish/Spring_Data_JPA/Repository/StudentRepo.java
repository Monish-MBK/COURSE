package com.monish.Spring_Data_JPA.Repository;

import com.monish.Spring_Data_JPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    List<Student> findBySname(String name);
    List<Student> findByMarks(int marks);
    List<Student> findByMarksGreaterThan(int marks);
}
