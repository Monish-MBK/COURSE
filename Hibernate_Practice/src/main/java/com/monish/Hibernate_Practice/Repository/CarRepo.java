package com.monish.Hibernate_Practice.Repository;

import com.monish.Hibernate_Practice.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Integer> {
}
