package com.Monish;

import com.Monish.Config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App
{
    public static void main( String[] args )
    {
//XML Based
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Alien ref =  context.getBean("alien", Alien.class);
////        ref.age=21;
//        ref.code();
//        System.out.println(ref.getAge());
//
////        Alien ref2= (Alien) context.getBean("alien");
////        ref2.code();
////        System.out.println(ref2.getAge());

//JAVA based
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Desktop dt = context.getBean("desktop1",Desktop.class);
//        dt.compiling();

        Alien ref = context.getBean(Alien.class);

        ref.code();
    }
}
