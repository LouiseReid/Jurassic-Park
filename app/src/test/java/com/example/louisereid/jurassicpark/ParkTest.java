package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.BackEnd.Dinosaurs.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Park;
import com.example.louisereid.jurassicpark.BackEnd.Humans.Visitor;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.Paddocks.PaddockState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        paddock1 = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);
        paddock2 = new Paddock(PaddockName.TREX, 5, DinoType.CARNIVORE);
        paddock3 = new Paddock(PaddockName.TRICERATOPS, 1, DinoType.HERBIVORE);
        visitor1 = new Visitor("Louise", PaddockName.TRICERATOPS, 50);
        visitor2 = new Visitor("Dave", PaddockName.AVIARY, 40);
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
