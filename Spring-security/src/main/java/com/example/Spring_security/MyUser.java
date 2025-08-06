package com.example.Spring_security;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String role;

}
