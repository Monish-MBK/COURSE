package com.example.Spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private MyUserRepo myUserRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUser createNewUser(@RequestBody MyUser myUser){
        //since we cannot store the password in plain text format we are encoding it
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return myUserRepo.save(myUser);
    }
}
