package com.example.louisereid.jurassicpark.BackEnd.Humans;

import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

/**
 * Created by louisereid on 12/11/2017.
 */

abstract public class Human {

    private String name;
    private PaddockName location;

    public Human(String name, PaddockName location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public PaddockName getLocation() {
        return location;
    }

    public void setLocation(PaddockName location) {
        this.location = location;
    }

    public String location(){
        return location.getName();
    }
}
