package com.example.main;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Example3 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle v1 = context.getBean("Audi",Vehicle.class);
        System.out.println("Vehicle name from spring context is :: "+ v1.getName());

        Vehicle v2 = context.getBean("RR",Vehicle.class);
        System.out.println("Vehicle name from spring context is :: "+ v2.getName());

        Vehicle v3 = context.getBean("Ferrari",Vehicle.class);
        System.out.println("Vehicle name from spring context is :: "+ v3.getName());
    }
}
