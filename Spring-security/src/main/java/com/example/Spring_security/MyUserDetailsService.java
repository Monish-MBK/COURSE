package com.example.Spring_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Optional;
//Accessing user details from database
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserRepo myUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //getting username from DB
        Optional<MyUser> username1=myUserRepo.findByUserName(username);
        if(username1.isPresent()){
            //If username is present in DB getting the MyUser object
            MyUser userObj = username1.get();
            return User.builder()
                    .username(userObj.getUserName())
                    .password(userObj.getPassword())
                    //creating a method to split multiple roles
                    .roles(getRoles(userObj))
                    .build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }
    //creating a method to split multiple roles
    public String[] getRoles(MyUser userObj){
        if (userObj.getRole()==null){
            return new String[]{"USER"};
        }else{
            return userObj.getRole().split(",");
        }
    }
}
