package com.example.main;

import com.example.config.ProjectConfig;
import com.example.model.Song;
import com.example.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example16 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vs = context.getBean(VehicleServices.class);
        System.out.println(vs.getClass());
        Song song = new Song();
        song.setTitle("Blank Space");
        song.setSingerName("Taylor Swift");
        boolean vehicleStarted = true;
        String moveVehicleStatus = vs.moveVehicle(vehicleStarted);
        String playMusicStatus = vs.playMusic(vehicleStarted,song);
        String applyBreakStatus = vs.applyBreak(vehicleStarted);
        System.out.println(moveVehicleStatus+"\n"+playMusicStatus+"\n"+applyBreakStatus);
    }
}
