package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;

import java.util.Random;

public interface Schatzkarte extends Karte
{
    default Karte getRandomSchatzkarte()
    {
        int count = Inventar.getTreasureCardList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getTreasureCardList().get(randomCardIndex);
    }
}
