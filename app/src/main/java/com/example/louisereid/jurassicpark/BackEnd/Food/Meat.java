package com.example.louisereid.jurassicpark.BackEnd.Food;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Meat extends Food {

    private DinoType suitableFor;

    public Meat(int nutritionalValue, DinoType suitableFor) {
        super(nutritionalValue);
        this.suitableFor = suitableFor;
    }

    public DinoType getSuitableFor() {
        return suitableFor;
    }

    
    @Override
    public int getNutritionalValue() {
        return 500;
    }
}



