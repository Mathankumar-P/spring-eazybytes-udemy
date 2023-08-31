package com.example.main;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example9 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle v = context.getBean(Vehicle.class);
        Person p = context.getBean(Person.class);
        System.out.println("Vehicle  name from Spring Context vehicle class : : " + v.getName());
        System.out.println("Person name from Spring Context : : " + p.getName());
        System.out.println("Vehicle name via Spring DependencyInjection : : " + p.getVehicle().getName());
    }
}
