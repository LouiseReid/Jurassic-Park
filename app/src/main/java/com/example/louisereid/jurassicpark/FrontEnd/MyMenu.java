package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.louisereid.jurassicpark.R;

public class MyMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.home){
            Intent home = new Intent(this, OptionsActivity.class);
            startActivity(home);
            return true;
        }
        if(item.getItemId() == R.id.raptors){
            Intent raptors = new Intent(this, AllRaptorsActivity.class);
            startActivity(raptors);
            return true;
        }
        if(item.getItemId() == R.id.trex){
            Intent raptors = new Intent(this, AllTRexActivity.class);
            startActivity(raptors);
            return true;
        }        if(item.getItemId() == R.id.aviary){
            Intent raptors = new Intent(this, AllAviaryActivity.class);
            startActivity(raptors);
            return true;
        }        if(item.getItemId() == R.id.triceratops){
            Intent raptors = new Intent(this, AllTriceratopsActivity.class);
            startActivity(raptors);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
