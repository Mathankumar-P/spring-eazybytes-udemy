package com.example.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Vehicle {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/* While using a Stereo type annotation spring context takes care of creating bean
if we want to execute some instruction for  post spring creates bean then we use @PostConstruct on top of a method in bean class*/
    @PostConstruct
    public void  init(){
        this.name="BMW";
        System.out.println("Printing from @PostConstruct");
    }
    public void hello(){
        System.out.println("Hello World from bean component");
    }
/* PreDestroy Annotation used on top of method
Spring makes sure to call this method before clearing and destroying context
this  is used to  close IO resources and connections => call from main as context.close */
    @PreDestroy
    public void preDestroy(){
        System.out.println("Printing from PreDestroy function");
    }
}
