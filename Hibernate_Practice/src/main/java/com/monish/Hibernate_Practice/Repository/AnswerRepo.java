package com.monish.Hibernate_Practice.Repository;

import com.monish.Hibernate_Practice.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {
}
