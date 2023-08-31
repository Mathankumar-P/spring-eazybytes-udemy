package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages="com.example.beans")
public class ProjectConfig {
    @Bean
    Vehicle vehicle1(){
        Vehicle v = new Vehicle();
        v.setName("Audi");
        return  v;
    }

    @Bean
    Vehicle vehicle2(){
        Vehicle v = new Vehicle();
        v.setName("Jaguar");
        return  v;
    }
    @Bean
    @Primary
    Vehicle vehicle3(){
        Vehicle v = new Vehicle();
        v.setName("Rolls Royce");
        return  v;
    }

}
