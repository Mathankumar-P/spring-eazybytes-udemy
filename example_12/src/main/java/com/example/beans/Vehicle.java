package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    static int objectCount = 0;
    public Vehicle(){
        System.out.println("vehicle bean created by spring context");
        this.name ="MiniCooper";
    }
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
