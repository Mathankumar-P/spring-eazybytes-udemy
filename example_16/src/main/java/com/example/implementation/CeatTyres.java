package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CeatTyres implements Tyres {
    @Override
    public String rotate() {
        return "Vehicle is Running with CEAT Tyres";
    }

    @Override
    public String stop() {
        return "Vehicle Stopped because of CEAT tyres";
    }
}
