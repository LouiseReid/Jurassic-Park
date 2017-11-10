package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.DinoType;
import com.example.louisereid.jurassicpark.Food.Edible;
import com.example.louisereid.jurassicpark.Food.Meat;
import com.example.louisereid.jurassicpark.Food.Plants;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

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
    private ArrayList<Edible> stomach;

    public Dinosaur(DinoType type, String name, int age, int weight) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.weight = weight;
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
