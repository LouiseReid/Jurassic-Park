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
    private ImageView paddockState;
    private Dino dino;
    private Button feedButton;
    private ImageView blackBG;
    private Button moveRaptors;


    Paddock paddock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        paddock = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);

        name = (TextView)findViewById(R.id.nameView);
        paddockState = (ImageView)findViewById(R.id.paddockStateView);
        feedButton = (Button)findViewById(R.id.feedBtn);
        blackBG = (ImageView)findViewById(R.id.blackbackView);
        moveRaptors = (Button)findViewById(R.id.raptorsMove);


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
        paddockState.setRotation((float) -45.0);
        blackBG.setVisibility(View.INVISIBLE);
        moveRaptors.setVisibility(View.INVISIBLE);

        if(dino.getType().equals("T-Rex")){
            moveRaptors.setVisibility(View.VISIBLE);
        }


    }

    public void onButtonClickFeed(View button){
        DBHelper dbHelper = new DBHelper(this);
        dino.feed(dbHelper);


//        paddockState.setVisibility(View.INVISIBLE);
//        PaddockState state = paddock.getState();
//        if(state.equals(PaddockState.RAMPAGE)){
//            paddockState.setVisibility(View.VISIBLE);
//            paddockState.setImageResource(state.getImage());
//            feedButton.setVisibility(View.INVISIBLE);
//            moveRaptors.setVisibility(View.INVISIBLE);
//            blackBG.setVisibility(View.VISIBLE);
////            Dino.deleteAll(dbHelper);
//        }
    }


    public void onButtonClickRaptors(View Button){
        DBHelper dbHelper = new DBHelper(this);
        dino.moveToRaptors(dbHelper);
    }



}
