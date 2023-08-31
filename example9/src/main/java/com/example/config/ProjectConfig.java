package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Vehicle vehicle (){
        Vehicle v = new Vehicle();
        v.setName("Suzuki");
        return v;
    }
    /*Spring Dependency Injection to Vehicle via method inside PersonBean
    Spring makes sures to create only one vehicle object Vehicle bean is always created first*/
    @Bean
    public Person person (){
        Person p = new Person();
        p.setName("Mathan");
        p.setVehicle(vehicle());
        return p;
    }
}
