package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_AGE;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_ID;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_NAME;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_PEN;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_STOMACH;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_TYPE;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_COLUMN_WEIGHT;
import static com.example.louisereid.jurassicpark.FrontEnd.DBHelper.DINO_TABLE;


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
    private int pen;

    public Dino(Integer id, String type, String name, int age, int weight, int stomachSize, int pen) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.stomachSize = stomachSize;
        this.pen = pen;
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

    public int getPen() {
        return pen;
    }

    public static ArrayList<Dino> all(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE, null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            int pen = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_PEN));
            Dino dino = new Dino(id, type, name, age, weight, stomach, pen);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }

    public static ArrayList<Dino> allRaptors(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = " WHERE pen = ?";
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE + query, new String[] {"1"});
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            int pen = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_PEN));
            Dino dino = new Dino(id, type, name, age, weight, stomach, pen);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }

    public static ArrayList<Dino> allTRex(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = " WHERE pen = ?";
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE + query, new String[] {"2"});
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            int pen = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_PEN));
            Dino dino = new Dino(id, type, name, age, weight, stomach, pen);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }

    public static ArrayList<Dino> allAviary(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = " WHERE pen = ?";
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE + query, new String[] {"3"});
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            int pen = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_PEN));
            Dino dino = new Dino(id, type, name, age, weight, stomach, pen);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }

    public static ArrayList<Dino> allTriceratops(DBHelper dbHelper){
        ArrayList<Dino> dinos = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = " WHERE pen = ?";
        Cursor cursor = db.rawQuery("SELECT * FROM " + DINO_TABLE + query, new String[] {"4"});
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_ID));
            String type = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_TYPE));
            String name = cursor.getString(cursor.getColumnIndex(DINO_COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_AGE));
            int weight = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_WEIGHT));
            int stomach = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_STOMACH));
            int pen = cursor.getInt(cursor.getColumnIndex(DINO_COLUMN_PEN));
            Dino dino = new Dino(id, type, name, age, weight, stomach, pen);
            dinos.add(dino);
        }
        cursor.close();
        return dinos;
    }



    public boolean feed(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = " id = ?";
        String[] values = {this.id.toString()};
        this.stomachSize += 1;
        ContentValues conValues = new ContentValues();
        conValues.put(DINO_COLUMN_STOMACH, this.stomachSize);
        db.update(DINO_TABLE, conValues, selection, values);
        return true;
    }


    public boolean moveToRaptors(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = " id = ?";
        String[] values = {this.id.toString()};
        this.pen = 1;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DINO_COLUMN_PEN, this.pen);
        db.update(DINO_TABLE, contentValues, selection, values);
        return true;
    }

    public boolean moveToTRex(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = " id = ?";
        String[] values = {this.id.toString()};
        this.pen = 2;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DINO_COLUMN_PEN, this.pen);
        db.update(DINO_TABLE, contentValues, selection, values);
        return true;
    }


    public static boolean deleteAll(DBHelper dbHelper){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + DINO_TABLE);
        return true;
    }



}
