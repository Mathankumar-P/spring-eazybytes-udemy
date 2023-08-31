package com.example.services;

import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {
    @Autowired
    private Speakers speaker;
    private Tyres tyres;
    public Speakers getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speakers speaker) {
        this.speaker = speaker;
    }

    public Tyres getTyres() {
        return tyres;
    }
    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public void playMusic(){
        String music = speaker.makeSound();
        System.out.println(music);
    }
    public void moveVehicle(){
        String rotate = tyres.rotate();
        System.out.println(rotate);
    }
}
