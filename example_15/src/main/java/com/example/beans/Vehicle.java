package com.example.beans;

import com.example.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "vehicleBean")
public class Vehicle {
    private String name;
    private final VehicleServices services ;

    @Autowired
    public Vehicle(VehicleServices services) {
        this.services = services;
    }
    public VehicleServices getServices() {
        return services;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
