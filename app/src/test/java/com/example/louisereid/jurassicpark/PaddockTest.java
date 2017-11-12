package com.example.louisereid.jurassicpark;

import com.example.louisereid.jurassicpark.BackEnd.DinoType;
import com.example.louisereid.jurassicpark.BackEnd.Dinosaur;
import com.example.louisereid.jurassicpark.BackEnd.PaddockName;
import com.example.louisereid.jurassicpark.BackEnd.Park;
import com.example.louisereid.jurassicpark.BackEnd.Paddock;
import com.example.louisereid.jurassicpark.BackEnd.PaddockState;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by louisereid on 10/11/2017.
 */

public class PaddockTest {

    Paddock paddock1;
    Paddock paddock2;
    Paddock paddock3;
    ArrayList<PaddockState> testState;
    Dinosaur tRex;
    Dinosaur diplodocus;
    Dinosaur apatosaurus;


    @Before
    public void before(){
        paddock1 = new Paddock(PaddockName.BRACHIOSAURUS, 20, DinoType.HERBIVORE);
        paddock2 = new Paddock(PaddockName.RAPTORS, 5, DinoType.CARNIVORE);
        paddock3 = new Paddock(PaddockName.TRICERATOPS, 1, DinoType.HERBIVORE);
        apatosaurus = new Dinosaur(DinoType.HERBIVORE, "Al", 190, 30);
        tRex = new Dinosaur(DinoType.CARNIVORE, "Big T", 250, 8);
        diplodocus = new Dinosaur(DinoType.HERBIVORE, "Larry", 360, 16);
        testState = new ArrayList<>();
        testState.add(PaddockState.RAMPAGE);
        testState.add(PaddockState.CALM);

    }

    @Test
    public void canGeneratePaddockState(){
        assertEquals(5, paddock1.getPaddockState().size());
    }

    @Test
    public void canGetStateAtIndex(){
        Paddock paddock = new Paddock(testState);
        assertEquals(PaddockState.RAMPAGE, paddock.getStateAtIndex(0));
        assertEquals(PaddockState.CALM, paddock.getStateAtIndex(1));
    }

    @Test
    public void canGetRandomState(){
        PaddockState s = paddock1.getState();
        assertNotNull(s);
        assert (s instanceof PaddockState);
    }

    @Test
    public void paddockHasDinos(){
        paddock1.addToPaddock(diplodocus);
        assertEquals(1, paddock1.paddockSize());
    }

    @Test
    public void paddockIsFull(){
        paddock3.addToPaddock(diplodocus);
        assertEquals("Paddocks full", paddock3.paddockFull());
    }

    @Test
    public void paddockCanOnlyAcceptDinosOfSameType(){
        paddock1.addToPaddock(tRex);
        assertEquals(0, paddock1.paddockSize());
    }

    @Test
    public void emptiesAfterRampage(){
        paddock1.addToPaddock(diplodocus);
        paddock1.addToPaddock(diplodocus);
        Paddock spy = Mockito.spy(paddock1);
        Mockito.when(spy.getState()).thenReturn(PaddockState.RAMPAGE);
        spy.checkForRampage();
        assertEquals(0, paddock1.paddockSize());

    }

    @Test
    public void doesntEmptyForOtherState(){
        paddock1.addToPaddock(diplodocus);
        paddock1.addToPaddock(diplodocus);
        Paddock spy = Mockito.spy(paddock1);
        Mockito.when(spy.getState()).thenReturn(PaddockState.CALM);
        spy.checkForRampage();
        assertEquals(2, paddock1.paddockSize());
    }


    @Test
    public void carnisCantGoInHerbPaddock(){
        paddock1.addToPaddock(tRex);
        assertEquals(0, paddock1.paddockSize());
    }

    @Test
    public void canRemoveDino(){
        paddock1.addToPaddock(diplodocus);
        paddock1.addToPaddock(apatosaurus);
        paddock1.removeFromPaddock(diplodocus);
        assertEquals(1, paddock1.paddockSize());
    }



    @Test
    public void canTransfer(){
        paddock1.addToPaddock(diplodocus);
        paddock1.transferDino(diplodocus, paddock1, paddock3);
        assertEquals(0, paddock1.paddockSize());
        assertEquals(1, paddock3.paddockSize());

    }

    @Test
    public void canRemoveSpecifiedDino(){
        paddock1.addToPaddock(diplodocus);
        paddock1.addToPaddock(apatosaurus);
        paddock1.removeDino(diplodocus);
        assertEquals(1, paddock1.paddockSize());
        assertEquals("Dino removed: Larry", paddock1.removeDino(diplodocus));
    }






}
