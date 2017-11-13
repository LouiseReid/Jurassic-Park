package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockState;
import com.example.louisereid.jurassicpark.R;

public class DinoActivity extends AppCompatActivity {

    private TextView name;
    private TextView stomach;
    private ImageView paddockState;
    private Dino dino;


    Paddock paddock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino);

        paddock = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);

        name = (TextView)findViewById(R.id.nameView);
        stomach = (TextView)findViewById(R.id.stomachView);
        paddockState = (ImageView)findViewById(R.id.test);


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


    }

    public void onButtonClickFeed(View button){
        DBHelper dbHelper = new DBHelper(this);
        dino.feed(dbHelper);
        stomach.setText(dino.getStomachSize().toString());

//        Intent i = new Intent(this, AllDinosActivity.class);
//        startActivity(i);

        paddockState.setVisibility(View.INVISIBLE);
        PaddockState state = paddock.getState();
        if(state.equals(PaddockState.RAMPAGE)){
            paddockState.setVisibility(View.VISIBLE);
            paddockState.setImageResource(state.getImage());
        }
    }




}
