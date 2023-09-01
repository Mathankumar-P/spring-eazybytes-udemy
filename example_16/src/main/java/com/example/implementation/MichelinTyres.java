package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MichelinTyres implements Tyres {
    @Override
    public String rotate() {

        return "Vehicle is Running with Michelin Tyres";
    }

    @Override
    public String stop() {
        return "Vehicle Stopped Because of Michelin Tyres";
    }
}
