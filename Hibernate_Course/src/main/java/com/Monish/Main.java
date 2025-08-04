package com.Monish;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setRollNo(1);
        s1.setsName("Monish");
        s1.setsAge(24);

        Configuration con = new Configuration();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        session.persist(s1);

    }
}