package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.BackEnd.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Park;
import com.example.louisereid.jurassicpark.BackEnd.Visitor;
import com.example.louisereid.jurassicpark.BackEnd.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.PaddockState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by louisereid on 10/11/2017.
 */

public class ParkTest {

    Park jurassicPark;
    Paddock paddock1;
    Paddock paddock2;
    Paddock paddock3;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void before(){
        jurassicPark = new Park(25, 1000);
        paddock1 = new Paddock("North Corner", 20, DinoType.HERBIVORE);
        paddock2 = new Paddock("East Wing", 5, DinoType.CARNIVORE);
        paddock3 = new Paddock("Central Enclosure", 1, DinoType.HERBIVORE);
        visitor1 = new Visitor("Louise", 50);
        visitor2 = new Visitor("Dave", 40);
    }

    @Test
    public void hasPaddocks(){
        jurassicPark.addPaddock(paddock1);
        assertEquals(1, jurassicPark.numPaddocks());
    }

    @Test
    public void parkLocksDownOnRampage(){
        Paddock spy = Mockito.spy(paddock1);
        Mockito.when(spy.getState()).thenReturn(PaddockState.RAMPAGE);
        assertEquals(true, jurassicPark.LockDown(spy));
    }

    @Test
    public void takingsIncreaseWithVisitors(){
        jurassicPark.takingsIncrease(jurassicPark.getEntryfee());
        assertEquals(1025, jurassicPark.getBank());
    }

    @Test
    public void canAddVisitorsToPark(){
        Paddock spy = Mockito.spy(paddock1);
        Mockito.when(spy.getState()).thenReturn(PaddockState.CALM);
        jurassicPark.addVisitors(visitor1, spy);
        jurassicPark.addVisitors(visitor2, spy);
        assertEquals(2, jurassicPark.visitorsInPark());
        assertEquals(1050, jurassicPark.getBank());
    }

    @Test
    public void visitorsCantEnterWhenRampagingDinos(){
        Paddock spy = Mockito.spy(paddock1);
        Mockito.when(spy.getState()).thenReturn(PaddockState.RAMPAGE);
        jurassicPark.addVisitors(visitor1, spy);
        jurassicPark.addVisitors(visitor2, spy);
        assertEquals(0, jurassicPark.visitorsInPark());
    }
}
