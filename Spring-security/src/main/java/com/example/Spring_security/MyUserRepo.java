package com.example.Spring_security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByUserName(String userName);
}
