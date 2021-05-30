package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;

import java.util.Random;

public interface Türkarte extends Karte
{

    static Türkarte getRandomTürkarte() {
        int count = Inventar.getTürKartenList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getTürKartenList().get(randomCardIndex);
    }
}
