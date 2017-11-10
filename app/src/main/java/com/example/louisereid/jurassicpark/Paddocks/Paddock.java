package com.example.louisereid.jurassicpark.Paddocks;

import com.example.louisereid.jurassicpark.DinoType;
import com.example.louisereid.jurassicpark.Dinosaur;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.id;
import static com.example.louisereid.jurassicpark.DinoType.HERBIVORE;

/**
 * Created by louisereid on 10/11/2017.
 */

public class Paddock {


    private String location;
    private int capacity;
    private DinoType type;
    private ArrayList<Dinosaur> dinosaurs;
    private ArrayList<PaddockState> paddockState;

    public Paddock(String location, int capacity, DinoType type) {
        this.location = location;
        this.capacity = capacity;
        this.type = type;
        dinosaurs = new ArrayList<>();
        paddockState = new ArrayList<>();
        generatePaddockState();
    }

    public Paddock(ArrayList<PaddockState> paddockState){
        this.paddockState = paddockState;
    }


    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public DinoType getType() {
        return type;
    }

    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public ArrayList<PaddockState> getPaddockState() {
        return paddockState;
    }

    private void generatePaddockState(){
        for(PaddockState state : PaddockState.values()){
            paddockState.add(state);
        }
    }

    private int getNumStates(){
        return paddockState.size();
    }

    public PaddockState getStateAtIndex(int index){
        return paddockState.get(index);
    }

    public int getRandomState(){
        Random rand = new Random();
        int listSize = getNumStates();
        int random = rand.nextInt(listSize);
        return random;
    }

    public PaddockState getState(){
        int index = getRandomState();
        return getStateAtIndex(index);
    }

    public void addToPaddock(Dinosaur dinosaur){
        if(type == dinosaur.getType() && paddockSize() < capacity) {
            dinosaurs.add(dinosaur);
        }
        if(paddockSize() >= capacity){
            paddockFull();
        }
    }

    public String paddockFull(){
        if(paddockSize() >= capacity){
        }
        return "Paddocks full";

    }

    public int paddockSize(){
        return dinosaurs.size();
    }

    public void checkForRampage(){
        if(getState() == PaddockState.RAMPAGE){
            dinosaurs.clear();
        }
    }


    public void removeFromPaddock(Dinosaur dinosaur){
        dinosaurs.remove(dinosaur);
    }








}
