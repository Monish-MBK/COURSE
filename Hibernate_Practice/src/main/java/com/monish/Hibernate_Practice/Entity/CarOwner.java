package com.monish.Hibernate_Practice.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "owner_table")
public class CarOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "carOwner",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Car> cars;

    public void addCar(Car car) {
        cars.add(car);
        car.setCarOwner(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public CarOwner(int id, String name, List<Car> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public CarOwner() {
    }
}
