package com.example.louisereid.jurassicpark.BackEnd.Food;

import com.example.louisereid.jurassicpark.BackEnd.Food.Edible;

/**
 * Created by louisereid on 10/11/2017.
 */

public abstract class Food  implements Edible {

    private int nutritionalValue;

    public Food(int nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }
}
