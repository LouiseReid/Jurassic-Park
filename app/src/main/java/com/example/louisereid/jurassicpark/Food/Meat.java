package com.example.louisereid.jurassicpark.Food;

import com.example.louisereid.jurassicpark.DinoType;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Meat implements Edible {

    private DinoType suitableFor;

    public Meat(DinoType suitableFor) {
        this.suitableFor = suitableFor;
    }

    public DinoType getSuitableFor() {
        return suitableFor;
    }
}
