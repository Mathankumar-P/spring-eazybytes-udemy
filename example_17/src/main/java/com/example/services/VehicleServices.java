package com.example.services;

import com.example.interfaces.LogAspect;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import com.example.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class VehicleServices {
    private final Logger logger = Logger.getLogger(VehicleServices.class.getName());
    @Autowired
    private Speakers speaker;
    private Tyres tyres;
    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
@LogAspect
    public String playMusic(boolean vehicleStarted, Song song){
//        Instant start = Instant.now();
//        logger.info("playMusic Method Execution starts");
//        String music = null;
//        if(vehicleStarted){
//            music = speaker.makeSound(song);
//        } else {
//            logger.log(Level.SEVERE, " Vehicle not started due to the perform operation");
//        }
//        logger.info ("playMusic Execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start,finish).toMillis();
//        logger.info("Time took to execute the method :: "+timeElapsed);
        return speaker.makeSound(song);
    }
    public String moveVehicle(boolean vehicleStarted){
//        Instant start = Instant.now();
//        logger.info("moveVehicle Method Execution starts");
//        String status = null;
//        if(vehicleStarted){
//            status = tyres.rotate();
//        } else {
//            logger.log(Level.SEVERE, " Vehicle not started due to the perform operation");
//        }
//        logger.info ("moveVehicle Execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start,finish).toMillis();
//        logger.info("Time took to execute the method :: "+timeElapsed);
        return tyres.rotate();
    }

    public String applyBreak(boolean vehicleStarted){
//        Instant start = Instant.now();
//        logger.info("apply Break Method Execution starts");
//        String status = null;
//        if(vehicleStarted){
//            status = tyres.stop();
//        } else {
//            logger.log(Level.SEVERE, "Vehicle not started due to the perform operation");
//        }
//        logger.info("apply Break Method Execution ends here");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start,finish).toMillis();
//        logger.info("Time took to execute the method :: "+timeElapsed);
        return tyres.stop();
    }
}
