package com.monish.Hibernate_Practice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int id;
    private String brand;
    @Column(name = "car_name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private CarOwner carOwner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public Car(int id, String brand, String name, CarOwner carOwner) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.carOwner = carOwner;
    }

    public Car() {
    }
}
