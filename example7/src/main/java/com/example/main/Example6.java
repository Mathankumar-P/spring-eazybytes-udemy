package com.example.main;
import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example6 {
    public static void main(String[] args) {
        Vehicle audi = new Vehicle();
        audi.setName("Audi");
        /*lambdaExpression way 1 => Definition outside and from that return */
        Supplier<Vehicle> audiSupplier = () -> audi;
        /*LambdaExpression way2 Definition inside*/
        Supplier<Vehicle>hondaSupplier=()->{
            Vehicle honda = new Vehicle();
            honda.setName("Honda");
            return honda;
        };
        Random number = new Random();
        int random = number.nextInt(10);
        System.out.println("Random Number : : "+ random);
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        if((random & 1)==1){
            context.registerBean("audi", Vehicle.class,audiSupplier);
        } else {
            context.registerBean("honda", Vehicle.class,hondaSupplier);
        }
        Vehicle audiVehicle = null;
        Vehicle hondaVehicle=null;
        try{
            audiVehicle =  context.getBean("audi", Vehicle.class);
        }catch (NoSuchBeanDefinitionException ne){
            System.out.println("Error while creating Audi Vehicle Object");
        }
        try{
            hondaVehicle =  context.getBean("honda", Vehicle.class);
        }catch (NoSuchBeanDefinitionException ne){
            System.out.println("Error while creating Honda Vehicle Object");
        }
        if(hondaVehicle!= null){
            System.out.println("Vehicle Name from Spring Context : : " + hondaVehicle.getName());
        } else {
            System.out.println("Vehicle Name from Spring Context : : " + audiVehicle.getName());
        }

    }
}
