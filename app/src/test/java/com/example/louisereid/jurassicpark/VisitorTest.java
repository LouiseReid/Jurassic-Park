package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.Paddocks.PaddockState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        visitor = new Visitor("Louise", 60);
        jurassicPark = new Park(25, 1000);
        paddock1 = new Paddock("North Corner", 20, DinoType.HERBIVORE);

    }

    @Test
    public void purseReducesOnEntry(){
        visitor.payEntry(jurassicPark.getEntryfee());
        assertEquals(35, visitor.getPurse());
    }



}
