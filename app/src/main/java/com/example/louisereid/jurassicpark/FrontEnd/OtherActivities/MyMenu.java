package com.example.louisereid.jurassicpark.FrontEnd.OtherActivities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllAviaryActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllDinosActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllRaptorsActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllTRexActivity;
import com.example.louisereid.jurassicpark.FrontEnd.AllDinosActivities.AllTriceratopsActivity;
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
            Intent trex = new Intent(this, AllTRexActivity.class);
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.rex);
            mp.start();
            startActivity(trex);
            return true;
        }        if(item.getItemId() == R.id.aviary){
            Intent aviary = new Intent(this, AllAviaryActivity.class);
            startActivity(aviary);
            return true;
        }        if(item.getItemId() == R.id.triceratops){
            Intent tric = new Intent(this, AllTriceratopsActivity.class);
            startActivity(tric);
            return true;
        }       if(item.getItemId() == R.id.all){
            Intent all = new Intent(this, AllDinosActivity.class);
            startActivity(all);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
