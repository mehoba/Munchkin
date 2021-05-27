package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KarteImpl;

import java.util.Random;

public class Schatzkarte extends KarteImpl
{
    int goldwert;

    public static Karte getRandomSchatzkarte()
    {
        int count = Inventar.getTreasureCardList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getTreasureCardList().get(randomCardIndex);
    }
}
