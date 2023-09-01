package com.example.main;
import com.example.beans.Person;
import com.example.config.ProjectConfig;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices v1 =context.getBean(VehicleServices.class);
        VehicleServices v2 =context.getBean(VehicleServices.class);
        System.out.println("HashCode of the Object VehicleServices v1 : : "+v1.hashCode());
        System.out.println("HashCode of the Object VehicleServices v2 : : "+v2.hashCode());
        if(v1==v2){
            System.out.println("VehicleServices Bean is a singleton scoped bean");
        } else {
            System.out.println("Vehicle Services hashcode is different");
        }

    }
}
