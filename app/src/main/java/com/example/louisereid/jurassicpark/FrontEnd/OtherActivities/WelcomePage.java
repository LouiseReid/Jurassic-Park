package com.example.louisereid.jurassicpark.FrontEnd.OtherActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.louisereid.jurassicpark.R;

public class WelcomePage extends AppCompatActivity {

    private ImageButton start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        start = (ImageButton)findViewById(R.id.startBtn);
    }

    public void onButtonClick(View button){
        Intent i = new Intent(this, OptionsActivity.class);
        startActivity(i);
    }
}
