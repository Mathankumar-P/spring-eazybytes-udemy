package com.example.main;
import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example8 {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("bean.xml");
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from the spring context using xml : : "+vehicle.getName());
    }
}
