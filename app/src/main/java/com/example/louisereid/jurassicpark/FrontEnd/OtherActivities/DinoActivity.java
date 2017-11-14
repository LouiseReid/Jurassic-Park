package com.example.louisereid.jurassicpark.FrontEnd.OtherActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockState;
import com.example.louisereid.jurassicpark.FrontEnd.Classes.Dino;
import com.example.louisereid.jurassicpark.FrontEnd.Classes.Pen;
import com.example.louisereid.jurassicpark.FrontEnd.DBHelper;
import com.example.louisereid.jurassicpark.R;

public class DinoActivity extends MyMenu {

    private TextView name;
    private TextView nameLabel;
    private TextView type;
    private TextView typeLabel;
    private TextView age;
    private TextView ageLabel;
    private TextView weight;
    private TextView weightLabel;
    private TextView kg;
    private ImageView picture;
    private ImageView paddockState;
    private Dino dino;
    private Button feedButton;
    private ImageView blackBG;
    private Button moveToRaptors;
    private Button moveToTRex;



    Paddock paddock;
    Pen pen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        paddock = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);


        name = (TextView)findViewById(R.id.nameView);
        nameLabel = (TextView)findViewById(R.id.name_);
        type = (TextView)findViewById(R.id.typeView);
        typeLabel = (TextView)findViewById(R.id.type_);
        age = (TextView)findViewById(R.id.ageView);
        ageLabel = (TextView)findViewById(R.id.age_);
        weight = (TextView)findViewById(R.id.weightView);
        weightLabel = (TextView)findViewById(R.id.weight_);
        kg = (TextView)findViewById(R.id.kg);
        picture = (ImageView)findViewById(R.id.pictureView);
        paddockState = (ImageView)findViewById(R.id.paddockStateView);
        feedButton = (Button)findViewById(R.id.feedBtn);
        blackBG = (ImageView)findViewById(R.id.blackbackView);
        moveToRaptors = (Button)findViewById(R.id.raptorsMove);
        moveToTRex = (Button)findViewById(R.id.trexMove);


        Intent i = getIntent();
        Bundle extras = i.getExtras();
        Integer id = extras.getInt("id");
        String dinoType = extras.getString("type");
        String dinoName = extras.getString("name");
        Integer dinoAge = extras.getInt("age");
        Integer stomachSize = extras.getInt("stomach");
        Integer dinoWeight = extras.getInt("weight");
        Integer pen = extras.getInt("pen");
        dino = new Dino(id, dinoType, dinoName, dinoAge, dinoWeight, stomachSize, pen);


        name.setText(dino.getName());
        type.setText(dino.getType());
        age.setText(dino.getAge().toString());
        weight.setText(dino.getWeight().toString());

        String resourceName = "com.example.louisereid.jurassicpark:drawable/" + dino.getName().toLowerCase();
        int imageId = getResources().getIdentifier(resourceName, null, null);
        picture.setImageResource(imageId);

        paddockState.setRotation((float) -45.0);
        blackBG.setVisibility(View.INVISIBLE);
        moveToRaptors.setVisibility(View.INVISIBLE);
        moveToTRex.setVisibility(View.INVISIBLE);



        if(dino.getPen() == 1){
            moveToTRex.setVisibility(View.VISIBLE);
        }
        if(dino.getPen() == 2){
            moveToRaptors.setVisibility(View.VISIBLE);
        }


    }

    public void onButtonClickFeed(View button){
        DBHelper dbHelper = new DBHelper(this);
        dino.feed(dbHelper);


        paddockState.setVisibility(View.INVISIBLE);
        PaddockState state = paddock.getState();
        if(state.equals(PaddockState.RAMPAGE)){
            paddockState.setVisibility(View.VISIBLE);
            paddockState.setImageResource(state.getImage());
            feedButton.setVisibility(View.INVISIBLE);
            moveToRaptors.setVisibility(View.INVISIBLE);
            moveToTRex.setVisibility(View.INVISIBLE);
            picture.setVisibility(View.INVISIBLE);
            name.setVisibility(View.INVISIBLE);
            nameLabel.setVisibility(View.INVISIBLE);
            type.setVisibility(View.INVISIBLE);
            typeLabel.setVisibility(View.INVISIBLE);
            age.setVisibility(View.INVISIBLE);
            ageLabel.setVisibility(View.INVISIBLE);
            weight.setVisibility(View.INVISIBLE);
            weightLabel.setVisibility(View.INVISIBLE);
            kg.setVisibility(View.INVISIBLE);

            blackBG.setVisibility(View.VISIBLE);

            Dino.deleteAll(dbHelper);
        }
    }


    public void onButtonClickRaptors(View Button){
        DBHelper dbHelper = new DBHelper(this);
        dino.moveToRaptors(dbHelper);
    }

    public void onButtonClickTRex(View Button){
        DBHelper dbHelper = new DBHelper(this);
        dino.moveToTRex(dbHelper);
    }



}
