package com.example.louisereid.jurassicpark.FrontEnd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.HashMap;

import static android.R.attr.name;
import static android.R.attr.type;
import static android.R.attr.value;

/**
 * Created by louisereid on 11/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dinosaurs.db";

    public static final String DINO_TABLE = "dinosaurs";
    public static final String DINO_COLUMN_ID = "id";
    public static final String DINO_COLUMN_TYPE = "type";
    public static final String DINO_COLUMN_NAME = "name";
    public static final String DINO_COLUMN_AGE = "age";
    public static final String DINO_COLUMN_WEIGHT = "weight";
    public static final String DINO_COLUMN_STOMACH = "stomach";
    public static final String DINO_COLUMN_PEN = "pen";

    public static final String PEN_TABLE = "pens";
    public static final String PEN_COLUMN_ID = "id";
    public static final String PEN_COLUMN_LOCATION = "location";




    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, 14);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + PEN_TABLE + "(id INTEGER primary key autoincrement, location TEXT)");
        db.execSQL("CREATE TABLE " + DINO_TABLE + "(id INTEGER primary key autoincrement, type TEXT, name TEXT, age INTEGER, weight INTEGER, stomach INTEGER, pen foreignkey REFERENCES pens(id))");

        db.execSQL("INSERT INTO " + PEN_TABLE + "(location) VALUES('Raptors')");
        db.execSQL("INSERT INTO " + PEN_TABLE + "(location) VALUES('TRex')");
        db.execSQL("INSERT INTO " + PEN_TABLE + "(location) VALUES('Aviary')");
        db.execSQL("INSERT INTO " + PEN_TABLE + "(location) VALUES('Triceratops')");

        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Velociraptor', 'Blue', 120, 150, 0, 1)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Velociraptor', 'Charlie', 120, 140, 4, 1)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Velociraptor', 'Delta', 120, 147, 0, 1)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Velociraptor', 'Echo', 120, 139, 7, 1)");

        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('T-Rex', 'Rex', 300, 8160, 0, 2)");

        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pterosaurs', 'Peter', 278, 250, 0, 3)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pterosaurs', 'Polly', 210, 243, 1, 3)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pterodactyl', 'Penelope', 240, 252, 3, 3)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pterodactyl', 'Francis', 350, 230, 0, 3)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pteranodon', 'Ted', 354, 229, 8, 3)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Pteranodon', 'Bob', 355, 251, 4, 3)");


        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Triceratop', 'Terry', 5000, 16, 0, 4)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Triceratop', 'Tracy', 5103, 16, 2, 4)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Triceratop', 'Agnes', 4800, 16, 4, 4)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Triceratop', 'Holly', 4982, 16, 1, 4)");
        db.execSQL("INSERT INTO " + DINO_TABLE + "(type, name, age, weight, stomach, pen) VALUES('Triceratop', 'Bruno', 5001, 16, 6, 4)");

    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + PEN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DINO_TABLE);
        onCreate(db);
    }


}

