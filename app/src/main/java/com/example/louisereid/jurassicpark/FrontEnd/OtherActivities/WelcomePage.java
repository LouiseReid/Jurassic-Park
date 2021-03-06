package com.example.louisereid.jurassicpark.FrontEnd.OtherActivities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.louisereid.jurassicpark.R;

public class WelcomePage extends AppCompatActivity {

    MediaPlayer mp;

    private ImageButton start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        start = (ImageButton)findViewById(R.id.startBtn);

    }

    public void onButtonClick(View button){
        Intent i = new Intent(this, OptionsActivity.class);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.welcome);
        mp.start();
        startActivity(i);
    }
}
