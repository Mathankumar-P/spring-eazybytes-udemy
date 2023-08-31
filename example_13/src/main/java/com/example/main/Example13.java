package com.example.main;
import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Example13 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /* Vehicle v = context.getBean(Vehicle.class);
        v.getServices().moveVehicle();
        v.getServices().playMusic(); */
        String[] persons = context.getBeanNamesForType(Person.class);// to store bean names
        Person person=context.getBean(Person.class);
        String[] vehicles = context.getBeanNamesForType(Vehicle.class);// to store bean names
        Vehicle v = context.getBean(Vehicle.class);
        person.getVehicle().getServices().playMusic();
        person.getVehicle().getServices().moveVehicle();
        System.out.println(Arrays.toString(persons));
        System.out.println(Arrays.toString(vehicles));
    }
}
