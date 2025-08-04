package com.monish.Spring_Ecom.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/home")
    public String hello(){
        return "Welcome to Monish Ecom";
    }
}
