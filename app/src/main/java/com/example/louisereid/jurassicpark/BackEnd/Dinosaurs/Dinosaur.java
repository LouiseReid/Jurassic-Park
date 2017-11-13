package com.example.louisereid.jurassicpark.BackEnd.Dinosaurs;

import com.example.louisereid.jurassicpark.BackEnd.Food.Edible;
import com.example.louisereid.jurassicpark.BackEnd.Food.Meat;
import com.example.louisereid.jurassicpark.BackEnd.Food.Plants;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

import java.util.ArrayList;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Dinosaur {

    Meat meat;
    Plants plants;


    private DinoType type;
    private String name;
    private int age;
    private int weight;
    private PaddockName location;
    private ArrayList<Edible> stomach;
    private int stomachSize;

    public Dinosaur(DinoType type, String name, int age, int weight, PaddockName location) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.location = location;
        stomach = new ArrayList<>();
    }



    public DinoType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PaddockName getLocation() {
        return location;
    }

    public void setLocation(PaddockName location) {
        this.location = location;
    }

    public ArrayList<Edible> getStomach() {
        return stomach;
    }

    public int stomachSize(){
        return stomach.size();
    }

    public void feedMeat(Meat meat){
        if(type == DinoType.CARNIVORE && meat.getSuitableFor() == DinoType.CARNIVORE) {
            stomach.add(meat);
        }
    }

    public void feedPlants(Plants plants){
        if(type == DinoType.HERBIVORE && plants.getSuitableFor() == DinoType.HERBIVORE) {
            stomach.add(plants);
        }
    }

    public boolean checkHungry(){
        if (stomachSize() < 2){
            return true;
        }
        return false;
    }

    public void sleep(){
        stomach.clear();
    }




}
