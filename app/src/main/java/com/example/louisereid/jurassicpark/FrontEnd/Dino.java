package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import java.util.ArrayList;

import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_AGE;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_ID;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_NAME;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_STOMACH;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_TYPE;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_WEIGHT;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_TABLE_NAME;

/**
 * Created by louisereid on 11/11/2017.
 */

public class Dino {

    private Integer id;
    private String type;
    private String name;
    private int age;
    private int weight;
    private int stomachSize;

    public Dino(Integer id, String type, String name, int age, int weight, int stomachSize) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.stomachSize = stomachSize;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getStomachSize() {
        return stomachSize;
    }

    public void feed(){
        stomachSize ++;

    }


    public static ArrayList<Dino> all(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE_NAME, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            Dino dino = new Dino(id, type, name, age, weight, stomach);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }

}
