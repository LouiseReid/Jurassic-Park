package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.Paddocks.PaddockState;

import java.util.ArrayList;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Park {


    private ArrayList<Paddock> paddocks;
    private int entryfee;
    private int bank;

    public Park(int entryfee, int bank) {
        this.entryfee = entryfee;
        this.bank = bank;
        paddocks = new ArrayList<>();
    }

    public ArrayList<Paddock> getPaddocks() {
        return paddocks;
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

}
