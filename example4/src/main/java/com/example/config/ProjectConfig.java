package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean (name = "Audi")
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }
    /* @Primary Annotation => if there is multiple beans availabe then from main calling the bean creates ambiguity
    to avoid this and to select default value we use @Primary Annotation. if there is an ambiguity spring context will choose
    the one which was made as @primary. we can give only one primary. multiple will create an exception.
     */
    @Primary
    @Bean (name = "RR")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Rolls Royce");
        return veh;
    }
    @Bean(name = "Ferrari")
    Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }
}

