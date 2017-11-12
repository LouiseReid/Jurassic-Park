package com.example.louisereid.jurassicpark.BackEnd;

import com.example.louisereid.jurassicpark.BackEnd.Humans.Visitor;

import java.util.ArrayList;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Park {


    private ArrayList<Visitor> visitors;
    private ArrayList<Paddock> paddocks;
    private int entryfee;
    private int bank;

    public Park(int entryfee, int bank) {
        this.entryfee = entryfee;
        this.bank = bank;
        paddocks = new ArrayList<>();
        visitors = new ArrayList<>();
    }

    public ArrayList<Paddock> getPaddocks() {
        return paddocks;
    }

    public ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public int getEntryfee() {
        return entryfee;
    }

    public int getBank() {
        return bank;
    }

    public int numPaddocks(){
        return paddocks.size();
    }

    public void addPaddock(Paddock paddock){
        paddocks.add(paddock);
    }

    public boolean LockDown(Paddock paddock){
        if (paddock.getState() == PaddockState.RAMPAGE){
            return true;
        }
        return false;
    }

    public int takingsIncrease(int entryfee){
        return this.bank += entryfee;
    }

    public int visitorsInPark(){
        return visitors.size();
    }

    public void addVisitors(Visitor visitor, Paddock paddock) {
        if (!LockDown(paddock)) {
            visitors.add(visitor);
            takingsIncrease(entryfee);
        }
    }
}
