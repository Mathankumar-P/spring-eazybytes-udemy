package com.example.beans;

public class Vehicle {
    static int objectCount = 0;
    public Vehicle(){
        objectCount++;
        System.out.println("Spring Context Created an object " + objectCount);
    }
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
