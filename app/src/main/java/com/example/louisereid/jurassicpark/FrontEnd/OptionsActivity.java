package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.louisereid.jurassicpark.R;

public class OptionsActivity extends AppCompatActivity {

    private Button raptor;
    private Button tRex;
    private Button aviary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        raptor = (Button)findViewById(R.id.raptorsBtn);
        tRex = (Button)findViewById(R.id.trexBtn);
        aviary = (Button)findViewById(R.id.aviaryBtn);
    }

    public void onRaptorButtonClick(View button){
        Intent i = new Intent(this, AllRaptorsActivity.class);
        startActivity(i);
    }

    public void onTRexButtonClick(View button){
        Intent i = new Intent(this, AllTRexActivity.class);
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
