package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    public Person(){
        System.out.println("Person Instance is Created");
    }
    private String  name ="Mathan";

    /* @Autowired Annotation marks field, method, constructor is used to auto wire bean
        that is  injecting beans at runtime by Spring Dependency IInjection mechanism
         */
    @Autowired
    private Vehicle vehicle;
    public String getName() {
        return name;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
