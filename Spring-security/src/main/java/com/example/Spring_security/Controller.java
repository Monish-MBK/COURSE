package com.example.Spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/home")
    public String home(){
        return "Home";
    }

    @GetMapping("/admin/home")
    public String admin(){
        return "Admin";
    }

    @GetMapping("/user/home")
    public String user(){
        return "User";
    }
}
