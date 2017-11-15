package com.example.louisereid.jurassicpark.FrontEnd.OtherActivities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.*;
import android.widget.ImageButton;

import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllAviaryActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllRaptorsActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllTRexActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllTriceratopsActivity;
import com.example.louisereid.jurassicpark.R;

public class OptionsActivity extends MyMenu {

    private ImageButton raptor;
    private ImageButton tRex;
    private ImageButton aviary;
    private ImageButton triceratops;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        tRex = (ImageButton) findViewById(R.id.trexBtn);
        raptor = (ImageButton)findViewById(R.id.raptorsBtn);
        aviary = (ImageButton)findViewById(R.id.aviaryBtn);
        triceratops = (ImageButton)findViewById(R.id.tricBtn);
    }

    public void onRaptorButtonClick(View button){
        Intent i = new Intent(this, AllRaptorsActivity.class);
        startActivity(i);
    }

    public void onTRexButtonClick(View button){
        Intent i = new Intent(this, AllTRexActivity.class);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.rex);
        mp.start();
        startActivity(i);
    }

    public void onAviaryButtonClick(View button){
        Intent i = new Intent(this, AllAviaryActivity.class);
        startActivity(i);
    }

    public void onTriceratopsButtonClick(View button){
        Intent i = new Intent(this, AllTriceratopsActivity.class);
        startActivity(i);
    }
}
