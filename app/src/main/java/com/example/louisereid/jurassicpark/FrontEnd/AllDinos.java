package com.example.louisereid.jurassicpark.FrontEnd;


import com.example.louisereid.jurassicpark.BackEnd.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Dinosaur;
import com.example.louisereid.jurassicpark.BackEnd.Food.Meat;

import java.util.ArrayList;

/**
 * Created by louisereid on 11/11/2017.
 */

public class AllDinos {

    Meat steak;

    private ArrayList<Dinosaur> dinosaurs;

    public AllDinos(){
        dinosaurs = new ArrayList<>();
        dinosaurs.add(trex);
        dinosaurs.add(diplodocus);
        dinosaurs.add(apatosaurus);
    }

    public ArrayList<Dinosaur> getList() {
        return new ArrayList<Dinosaur>(dinosaurs);
    }

    Dinosaur trex = new Dinosaur(DinoType.CARNIVORE, "Big T", 10, 10, 0);
    Dinosaur diplodocus = new Dinosaur(DinoType.HERBIVORE, "Larry", 360, 16, 1);
    Dinosaur apatosaurus = new Dinosaur(DinoType.HERBIVORE, "Al", 190, 30, 3);


}
