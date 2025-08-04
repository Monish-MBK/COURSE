package com.monish.Hibernate_Practice.Controller;

import com.monish.Hibernate_Practice.Entity.Question;
import com.monish.Hibernate_Practice.Service.QandAservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QandAcontroller {
    @Autowired
    private QandAservice qandAservice;
    @PostMapping("/addquestion")
    public ResponseEntity<Question> addQ(@RequestBody Question question){
        return new ResponseEntity<>(qandAservice.addQ(question), HttpStatus.CREATED);
    }
}
