package com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.louisereid.jurassicpark.FrontEnd.DBHelper;
import com.example.louisereid.jurassicpark.FrontEnd.Classes.Dino;
import com.example.louisereid.jurassicpark.FrontEnd.OtherActivities.DinoActivity;
import com.example.louisereid.jurassicpark.FrontEnd.Classes.DinoAdapter;
import com.example.louisereid.jurassicpark.FrontEnd.OtherActivities.MyMenu;
import com.example.louisereid.jurassicpark.R;

import java.util.ArrayList;

public class AllTRexActivity extends MyMenu {


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinos_list);

        dbHelper = new DBHelper(this);
        ArrayList<Dino> dinos = Dino.allTRex(dbHelper);

        DinoAdapter dinoAdapter = new DinoAdapter(this, dinos);
        ListView listView = (ListView)findViewById(R.id.dinoList);
        listView.setAdapter(dinoAdapter);

    }

    public void getDino(View listItem){
        Dino dinosaur = (Dino) listItem.getTag();
        Intent i = new Intent(this, DinoActivity.class);
        i.putExtra("id", dinosaur.getId());
        i.putExtra("name", dinosaur.getName());
        i.putExtra("stomach", dinosaur.getStomachSize());
        i.putExtra("age", dinosaur.getAge());
        i.putExtra("weight", dinosaur.getWeight());
        i.putExtra("type", dinosaur.getType());
        i.putExtra("pen", dinosaur.getPen());
        startActivity(i);
    }
}
