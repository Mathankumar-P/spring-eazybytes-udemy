package com.example.main;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Example4 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle v2 = context.getBean(Vehicle.class);
        System.out.println("Primary Annotation name  spring context is :: "+ v2.getName());

        Vehicle v3 = context.getBean("Ferrari",Vehicle.class);
        System.out.println("Vehicle name from spring context is :: "+ v3.getName());
    }
}
