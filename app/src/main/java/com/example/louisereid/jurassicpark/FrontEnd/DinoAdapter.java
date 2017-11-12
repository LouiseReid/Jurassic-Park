package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaur;
import com.example.louisereid.jurassicpark.R;

import java.util.ArrayList;


/**
 * Created by louisereid on 11/11/2017.
 */

public class DinoAdapter extends ArrayAdapter<Dino> {

    public DinoAdapter(Context context, ArrayList<Dino> dinos) {
        super(context, 0, dinos);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.dino_item, parent, false);
        }

        Dino currentDino = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.itemName);
        name.setText(currentDino.getName());

        if(getItem(position).getStomachSize() < 1){
            listItemView.setBackgroundColor(Color.RED);
        }
        if(getItem(position).getStomachSize() >= 1 && getItem(position).getStomachSize() < 3){
            listItemView.setBackgroundColor(Color.rgb(255,165,0));
        }
        if(getItem(position).getStomachSize() >= 3){
            listItemView.setBackgroundColor(Color.rgb(50,205,50));
        }

        listItemView.setTag(currentDino);


        return listItemView;
    }



}