package com.monish.app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    @Override
    @Primary
    public void compile() {
        System.out.println("Compiling from desktop");
    }
}
