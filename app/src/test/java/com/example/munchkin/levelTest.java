package com.example.munchkin;

import com.example.munchkin.Activity.SpielfeldActivity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class levelTest {
    Level level;

    @Before
    public void setUp(){
        level= new Level();
    }

    @Test
    public void checkIfDecreaseNeverUnder1(){
        level.levelDecrease();
        assertEquals(level.getLevel(),  1);
    }


    @Test
    public void checkIfIncrease(){
        level.levelIncrease();
        assertEquals(level.getLevel(),  2);
    }

    @Test
    public void checkIfDecrease(){
        level.levelDecrease();
        assertEquals(level.getLevel(),  1);
    }

    @Test
    public void checkIncreaseTo10(){
        for(int i=1; i<10; i++){         //erhöht bis 9
            level.levelIncrease();
        }
        assertEquals(level.getLevel(),  10);
    }



}
