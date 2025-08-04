package com.Monish;
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }
}
//Maven provides unique structure to the project
//We can have the dependencies in pom[Project Object Model] in the XML format
//We have to add dependencies using dependency tag
//Archtype is a template which can be used to build a project of pre defined template