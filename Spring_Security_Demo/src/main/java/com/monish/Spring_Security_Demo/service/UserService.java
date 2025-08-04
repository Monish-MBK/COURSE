package com.monish.Spring_Security_Demo.service;

import com.monish.Spring_Security_Demo.Repository.UserRepo;
import com.monish.Spring_Security_Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    //Registering new user
    public User saveUser(User user){
        //Encoding the password using Bcrypt password encoder
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
