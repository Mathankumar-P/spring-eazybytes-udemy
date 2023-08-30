package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Example1 {
    public static void main(String[] args) {
        //Direct Call to Java Bean (Vehicle)
        Vehicle v1 = new Vehicle();
        v1.setName("Audi");
        System.out.println("Vehicle name created using direct Object Creation : : " + v1.getName());
        /* Var - key word automatically recognizes the data types. [java 10]*/
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*No need of Explicit type casting = context recognizes the return tye.*/
        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("Vehicle name Creating using spring context : : "+ v2.getName());

        String hello = context.getBean(String.class);
        System.out.println("String Value from the context is : : " + hello);
        Integer number = context.getBean(Integer.class);
        System.out.println("Integer value from the contect : : "+number);
    }
}
