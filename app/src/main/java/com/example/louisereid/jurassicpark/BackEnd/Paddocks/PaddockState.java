package com.example.louisereid.jurassicpark.BackEnd.Paddocks;

import com.example.louisereid.jurassicpark.R;

/**
 * Created by louisereid on 10/11/2017.
 */

public enum PaddockState {

    RAMPAGE(R.drawable.rampaging),
    CALM(R.drawable.rampaging),
    SLEEPING(R.drawable.rampaging),
    EATING(R.drawable.rampaging),
    ROAMING(R.drawable.rampaging);

    private int image;

    PaddockState(int image) {
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }
}
