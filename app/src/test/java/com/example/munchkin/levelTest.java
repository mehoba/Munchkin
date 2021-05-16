package com.example.munchkin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class levelTest {
    Level level= new Level();

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

}
