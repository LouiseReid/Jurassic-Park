package com.example.louisereid.jurassicpark.BackEnd.Humans;

import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Visitor extends Human {

    private int purse;

    public Visitor(String name, PaddockName location, int purse) {
        super(name, location);
        this.purse = purse;
    }


    public int getPurse() {
        return purse;
    }


    public void payEntry(int parkFee){
        this.purse -= parkFee;
    }


}
