package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockState;
import com.example.louisereid.jurassicpark.R;

public class DinoActivity extends MyMenu {

    private TextView name;
    private TextView stomach;
    private ImageView paddockState;
    private Dino dino;
    private Button feedButton;
    private ImageView blackBG;


    Paddock paddock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        paddock = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);

        name = (TextView)findViewById(R.id.nameView);
        stomach = (TextView)findViewById(R.id.stomachView);
        paddockState = (ImageView)findViewById(R.id.paddockStateView);
        feedButton = (Button)findViewById(R.id.feedBtn);
        blackBG = (ImageView)findViewById(R.id.blackbackView);


        Intent i = getIntent();
        Bundle extras = i.getExtras();
        Integer id = extras.getInt("id");
        String type = extras.getString("type");
        String dinoName = extras.getString("name");
        Integer age = extras.getInt("age");
        Integer stomachSize = extras.getInt("stomach");
        Integer weight = extras.getInt("weight");
        Integer pen = extras.getInt("pen");
        dino = new Dino(id,type, dinoName, age, weight, stomachSize, pen);


        name.setText(dino.getName());
        stomach.setText(dino.getStomachSize().toString());
        paddockState.setRotation((float) -45.0);
        blackBG.setVisibility(View.INVISIBLE);


    }

    public void onButtonClickFeed(View button){
        DBHelper dbHelper = new DBHelper(this);
        dino.feed(dbHelper);
        stomach.setText(dino.getStomachSize().toString());

        paddockState.setVisibility(View.INVISIBLE);
        PaddockState state = paddock.getState();
        if(state.equals(PaddockState.RAMPAGE)){
            paddockState.setVisibility(View.VISIBLE);
            paddockState.setImageResource(state.getImage());
            feedButton.setVisibility(View.INVISIBLE);
            blackBG.setVisibility(View.VISIBLE);


        }
    }






}
