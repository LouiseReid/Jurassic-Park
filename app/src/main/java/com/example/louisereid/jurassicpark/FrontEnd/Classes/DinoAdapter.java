package com.example.louisereid.jurassicpark.FrontEnd.Classes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.louisereid.jurassicpark.FrontEnd.Classes.Dino;
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
        TextView type = (TextView)listItemView.findViewById(R.id.itemType);
        type.setText(currentDino.getType());

        if(getItem(position).getStomachSize() < 5){
            listItemView.setBackgroundColor(Color.rgb(221, 59, 59));
        }
        if(getItem(position).getStomachSize() >= 5 && getItem(position).getStomachSize() < 8){
            listItemView.setBackgroundColor(Color.rgb(255,165,0));
        }
        if(getItem(position).getStomachSize() >= 8){
            listItemView.setBackgroundColor(Color.rgb(50,205,50));
        }

        listItemView.setTag(currentDino);


        return listItemView;
    }



}