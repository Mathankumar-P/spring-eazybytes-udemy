package com.example.main;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Example2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        /*NoUniqueBeanFoundException
            //Having Multiple Bean that returns same Object
            //while accessing vehicle   there will be ambiguity for context as which on to choose
            Vehicle veh = context.getBean(Vehicle.class);
            System.out.println("Vehicle name from spring context is :: "+ veh.getName());
         */

        /* Using exact class name while accesing  the method to avoid Exception */
        Vehicle veh = context.getBean("vehicle2",Vehicle.class);
        System.out.println("Vehicle name from spring context is :: "+ veh.getName());

    }
}
