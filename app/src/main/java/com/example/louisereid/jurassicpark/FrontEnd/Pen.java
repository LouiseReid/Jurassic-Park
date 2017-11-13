package com.example.louisereid.jurassicpark.FrontEnd;

/**
 * Created by louisereid on 13/11/2017.
 */

public class Pen {

    private int id;
    private String location;

    public Pen(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
