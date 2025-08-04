package com.Monish.Config;

import com.Monish.Alien;
import com.Monish.Computer;
import com.Monish.Desktop;
import com.Monish.Laptop;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.Monish")
public class AppConfig {

//    @Bean
//    public Alien alien(Computer computer){
//        Alien ref = new Alien();
//        ref.setAge(25);
//        ref.setCom(computer);
//        return ref;
//    }
//
//    @Bean(name = "desktop1")
//    @Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
