package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.R;

public class DinoActivity extends AppCompatActivity {

    private TextView name;
    private TextView stomach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        name = (TextView)findViewById(R.id.nameView);
        stomach = (TextView)findViewById(R.id.stomachView);


        Intent i = getIntent();
        Bundle extras = i.getExtras();

        String nameString = extras.get("name").toString();
        String stomachString = extras.get("stomach").toString();

        name.setText(nameString);
        stomach.setText(stomachString);

    }


}
