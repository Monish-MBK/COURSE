package com.Monish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("30")
    private int age;
    @Autowired
    private Computer com;

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Alien(){
//        System.out.println("Object created...");
    }
    public Alien(int age){
        this.age=age;
    }

    public Alien(int age, Laptop lap) {
        System.out.println("Both parameters");
        this.age = age;
        this.com = lap;
    }

    public void code(){
        System.out.println("coding...");
        com.compiling();
        System.out.println(getAge());
    }
}
