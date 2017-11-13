package com.example.louisereid.jurassicpark.BackEnd.Paddocks;

/**
 * Created by louisereid on 12/11/2017.
 */

public enum PaddockName {


    RAPTORS("Raptors"),
    AVIARY("The Aviary"),
    TREX("Tyrannosaur Enclosure"),
    QUARANTINE("Quarantine Pens"),
    BRACHIOSAURUS("Brachiosaurus Enclosure"),
    PETTINGZOO("Gentle Giants Petting Zoo"),
    TRICERATOPS("Triceratops Paddock");

    private String name;

    PaddockName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
