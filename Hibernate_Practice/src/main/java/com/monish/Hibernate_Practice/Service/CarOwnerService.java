package com.monish.Hibernate_Practice.Service;

import com.monish.Hibernate_Practice.Entity.Car;
import com.monish.Hibernate_Practice.Entity.CarOwner;
import com.monish.Hibernate_Practice.Repository.CarOwnerRepo;
import com.monish.Hibernate_Practice.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarOwnerService {
    @Autowired
    private CarOwnerRepo ownerRepo;
    @Autowired
    private CarRepo carRepo;

    public CarOwner addOwner(CarOwner carOwner) {
        for (Car car:carOwner.getCars()){
            car.setCarOwner(carOwner);
        }
        return ownerRepo.save(carOwner);

    }
}
