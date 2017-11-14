package com.example.louisereid.jurassicpark.BackEnd.Humans;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.Dinosaur;
import com.example.louisereid.jurassicpark.BackEnd.Food.Meat;
import com.example.louisereid.jurassicpark.BackEnd.Food.Plants;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

/**
 * Created by louisereid on 12/11/2017.
 */

public class Ranger extends Human {

    Dinosaur dinosaur;
    Plants plants;
    Meat meat;

    private int shiftLength;

    public Ranger(String name, PaddockName location, int shiftLength) {
        super(name, location);
        this.shiftLength = shiftLength;
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public void changeShiftLength(int shiftLength) {
        this.shiftLength += shiftLength;
    }

    public void feedHerbivore(Dinosaur dinosaur, Plants plants){
        dinosaur.feedPlants(plants);
    }

    public void feedCarnivore(Dinosaur dinosaur, Meat meat){
        dinosaur.feedMeat(meat);
        changeShiftLength(-2);
    }
}
