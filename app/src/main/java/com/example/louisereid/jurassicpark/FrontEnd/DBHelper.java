package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.HashMap;

/**
 * Created by louisereid on 11/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dinosaurs.db";
    public static final String DINO_TABLE_NAME = "dinosaurs";
    public static final String DINO_COLUMN_ID = "id";
    public static final String DINO_COLUMN_TYPE = "type";
    public static final String DINO_COLUMN_NAME = "name";
    public static final String DINO_COLUMN_AGE = "age";
    public static final String DINO_COLUMN_WEIGHT = "weight";
    public static final String DINO_COLUMN_STOMACH = "stomach";
    private HashMap hp;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + DINO_TABLE_NAME + "(id INTEGER primary key autoincrement, type TEXT, name TEXT, age INTEGER, weight INTEGER, stomach INTEGER )");
        db.execSQL("INSERT INTO " + DINO_TABLE_NAME + "('type', 'name', 'age', 'weight', 'stomach') VALUES ('Diplodocus', 'Larry', '360', '16', '0')");
    }



    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + DINO_TABLE_NAME);
        onCreate(db);
    }
}

