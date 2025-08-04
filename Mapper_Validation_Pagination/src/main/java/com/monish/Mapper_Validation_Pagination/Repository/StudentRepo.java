package com.monish.Mapper_Validation_Pagination.Repository;

import com.monish.Mapper_Validation_Pagination.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
