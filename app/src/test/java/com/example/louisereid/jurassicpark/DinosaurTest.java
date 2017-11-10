package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.Food.Meat;
import com.example.louisereid.jurassicpark.Food.Plants;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 10/11/2017.
 */

public class DinosaurTest {

    Dinosaur tRex;
    Dinosaur diplodocus;
    Meat steak;
    Plants foliage;

    @Before
    public void before(){
        tRex = new Dinosaur(DinoType.CARNIVORE, "Big T", 250, 8);
        diplodocus = new Dinosaur(DinoType.HERBIVORE, "Larry", 360, 16);
        steak = new Meat(DinoType.CARNIVORE);
        foliage = new Plants(DinoType.HERBIVORE);
    }

    @Test
    public void hasEmptyStomach(){
        assertEquals(0, tRex.getStomach().size());
    }

    @Test
    public void canEatMeat(){
        tRex.feedMeat(steak);
        diplodocus.feedMeat(steak);
        assertEquals(1, tRex.stomachSize());
        assertEquals(0, diplodocus.stomachSize());

    }

    @Test
    public void canEatPlants(){
        diplodocus.feedPlants(foliage);
        diplodocus.feedPlants(foliage);
        tRex.feedPlants(foliage);
        assertEquals(2, diplodocus.stomachSize());
        assertEquals(0, tRex.stomachSize());
    }

    @Test
    public void canGetHungry(){
        diplodocus.feedPlants(foliage);
        tRex.feedMeat(steak);
        tRex.feedMeat(steak);
        assertEquals(true, diplodocus.checkHungry());
        assertEquals(false, tRex.checkHungry());
    }

    @Test
    public void stomachEmpties(){
        diplodocus.feedPlants(foliage);
        diplodocus.sleep();
        assertEquals(0, diplodocus.stomachSize());
    }


}
