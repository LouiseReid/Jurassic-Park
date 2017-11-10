package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.Paddocks.PaddockState;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Visitor {

    Paddock paddock;

    private String name;
    private int purse;

    public Visitor(String name, int purse) {
        this.name = name;
        this.purse = purse;
    }

    public String getName() {
        return name;
    }

    public int getPurse() {
        return purse;
    }


    public void payEntry(int parkFee){
        this.purse -= parkFee;
    }


}
