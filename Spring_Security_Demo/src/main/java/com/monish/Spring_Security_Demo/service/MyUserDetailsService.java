package com.monish.Spring_Security_Demo.service;

import com.monish.Spring_Security_Demo.Repository.UserRepo;
import com.monish.Spring_Security_Demo.model.User;
import com.monish.Spring_Security_Demo.model.UserDetailesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserDetailesImpl(user);
    }
}
