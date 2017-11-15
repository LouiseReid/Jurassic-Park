package com.example.louisereid.jurassicpark.BackEnd.Food;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;

import static com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType.CARNIVORE;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Plants extends Food {


    private DinoType suitableFor;


    public Plants(int nutritionalValue, DinoType suitableFor) {
        super(nutritionalValue);
        this.suitableFor = suitableFor;
    }

    public DinoType getSuitableFor() {
        return suitableFor;
    }



    @Override
    public int getNutritionalValue() {
        return 200;
    }
}
