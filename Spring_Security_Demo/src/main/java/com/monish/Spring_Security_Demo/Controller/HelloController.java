package com.monish.Spring_Security_Demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Frequency;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        return "Hello World" + request.getSession().getId();  //It will print the session id also
    }
    @GetMapping("/about")
    public String about(HttpServletRequest request){
        return "Monish" + request.getSession().getId();       //Both will have the same session id since both the pages can be accessed in a single login
    }
}
