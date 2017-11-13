package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Park;
import com.example.louisereid.jurassicpark.BackEnd.Humans.Visitor;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.Paddock;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 10/11/2017.
 */

public class VisitorTest {

    Visitor visitor;
    Park jurassicPark;
    Paddock paddock1;


    @Before
    public void before(){
        visitor = new Visitor("Louise", PaddockName.TRICERATOPS, 60);
        jurassicPark = new Park(25, 1000);
        paddock1 = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);

    }

    @Test
    public void purseReducesOnEntry(){
        visitor.payEntry(jurassicPark.getEntryfee());
        assertEquals(35, visitor.getPurse());
    }

    @Test
    public void canMoveLocations(){
        visitor.setLocation(PaddockName.TRICERATOPS);
        assertEquals("Triceratops Paddock", visitor.location());
    }



}
