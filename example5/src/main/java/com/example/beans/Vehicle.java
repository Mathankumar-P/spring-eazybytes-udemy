package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello(){
        System.out.println("Hello World from bean component");
    }
}
