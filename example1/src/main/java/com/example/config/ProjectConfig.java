package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle1(){
        Vehicle veh = new Vehicle();
        veh.setName("Rolls Royce");
        return veh;
    }
    @Bean
    String hell(){
        return "Hello World";
    }

    @Bean
    Integer number (){
        return 45;
    }
}
