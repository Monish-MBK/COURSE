package com.monish.Hibernate_Practice.Repository;

import com.monish.Hibernate_Practice.Entity.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOwnerRepo extends JpaRepository<CarOwner,Integer> {
}
