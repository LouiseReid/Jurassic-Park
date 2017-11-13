package com.example.louisereid.jurassicpark;

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

    @Before
    public void before(){
        ranger = new Ranger("Chris", PaddockName.AVIARY, 10);
        ranger2 = new Ranger("Alanna", PaddockName.QUARANTINE, 10);
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

}
