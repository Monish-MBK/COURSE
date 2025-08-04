package com.Monish;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void compiling(){
        System.out.println("Compiling from laptop;");
    }
}
