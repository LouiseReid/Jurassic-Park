package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.Dinosaur;
import com.example.louisereid.jurassicpark.BackEnd.Food.Meat;
import com.example.louisereid.jurassicpark.BackEnd.Food.Plants;
import com.example.louisereid.jurassicpark.BackEnd.Humans.Ranger;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 12/11/2017.
 */

public class RangerTest {

    Ranger ranger;
    Ranger ranger2;
    Dinosaur diplodocus;
    Dinosaur tRex;
    Plants foliage;
    Meat steak;

    @Before
    public void before(){
        ranger = new Ranger("Chris", PaddockName.AVIARY, 10);
        ranger2 = new Ranger("Alanna", PaddockName.QUARANTINE, 10);
        diplodocus = new Dinosaur(DinoType.HERBIVORE, "Larry", 360, 16, PaddockName.PETTINGZOO);
        tRex = new Dinosaur(DinoType.CARNIVORE, "Big T", 250, 8, PaddockName.TREX);
        foliage = new Plants(200, DinoType.HERBIVORE);
        steak = new Meat(500, DinoType.CARNIVORE);

    }

    @Test
    public void canMoveLocations(){
        ranger.setLocation(PaddockName.TRICERATOPS);
        assertEquals("Triceratops Paddock", ranger.location());
    }

    @Test
    public void canIncreaseDecreaseHours(){
        ranger.changeShiftLength(2);
        ranger2.changeShiftLength(-2);
        assertEquals(12, ranger.getShiftLength());
        assertEquals(8, ranger2.getShiftLength());
    }

    @Test
    public void canFeedHerbivore(){
        ranger.feedHerbivore(diplodocus, foliage);
        assertEquals(1, diplodocus.stomachSize());
    }

    @Test
    public void canFeedCarnivore(){
        ranger.feedCarnivore(tRex, steak);
        assertEquals(1, tRex.stomachSize());
        assertEquals(8, ranger.getShiftLength());
    }

}
