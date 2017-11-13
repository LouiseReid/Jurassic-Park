package com.example.louisereid.jurassicpark.BackEnd.Humans;

import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

/**
 * Created by louisereid on 12/11/2017.
 */

public class Ranger extends Human {

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
}
