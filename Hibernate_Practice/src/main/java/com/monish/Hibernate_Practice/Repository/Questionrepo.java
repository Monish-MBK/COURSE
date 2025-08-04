package com.monish.Hibernate_Practice.Repository;

import com.monish.Hibernate_Practice.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Questionrepo extends JpaRepository<Question,Integer> {
}
