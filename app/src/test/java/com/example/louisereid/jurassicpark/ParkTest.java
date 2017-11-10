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

public class ParkTest {

    Park jurassicPark;
    Paddock paddock1;
    Paddock paddock2;
    Paddock paddock3;

    @Before
    public void before(){
        jurassicPark = new Park(25, 1000);
        paddock1 = new Paddock("North Corner", 20, DinoType.HERBIVORE);
        paddock2 = new Paddock("East Wing", 5, DinoType.CARNIVORE);
        paddock3 = new Paddock("Central Enclosure", 1, DinoType.HERBIVORE);
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
}
