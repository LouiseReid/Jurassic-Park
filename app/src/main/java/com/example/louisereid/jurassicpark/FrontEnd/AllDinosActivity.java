package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaur;
import com.example.louisereid.jurassicpark.R;

import java.util.ArrayList;

import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_TABLE_NAME;

public class AllDinosActivity extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinos_list);

        dbHelper = new DBHelper(this);
        ArrayList<Dino> dinos = Dino.all(dbHelper);

        DinoAdapter dinoAdapter = new DinoAdapter(this, dinos);
        ListView listView = (ListView)findViewById(R.id.dinoList);
        listView.setAdapter(dinoAdapter);



    }

    public void getDino(View listItem){
        Dino dinosaur = (Dino) listItem.getTag();
        Intent i = new Intent(this, DinoActivity.class);
        i.putExtra("name", dinosaur.getName());
        i.putExtra("stomach", dinosaur.getStomachSize());
        startActivity(i);
    }




}
