package com.monish.Hibernate_Practice.Controller;

import com.monish.Hibernate_Practice.Entity.CarOwner;
import com.monish.Hibernate_Practice.Service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarOwnerController {
    @Autowired
    private CarOwnerService carService;
    @PostMapping("/add/owner")
    public ResponseEntity<CarOwner> addowner(@RequestBody CarOwner carOwner){
        return new ResponseEntity<>(carService.addOwner(carOwner), HttpStatus.CREATED);
    }

}
