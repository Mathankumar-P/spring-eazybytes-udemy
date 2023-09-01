package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = { com.example.beans.Vehicle.class, com.example.beans.Person.class})
@ComponentScan(basePackages = {"com.example.implementation","com.example.services"})
public class ProjectConfig {

}
