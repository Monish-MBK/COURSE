package com.monish.Spring_Security_Demo.Controller;

import com.monish.Spring_Security_Demo.model.User;
import com.monish.Spring_Security_Demo.service.JwtService;
import com.monish.Spring_Security_Demo.service.UserService;
import com.sun.jdi.PrimitiveValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.getToken(user.getUsername());
        else
            return "Failed to login";
    }
}
