package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;

import java.util.Random;

public interface Schatzkarte extends Karte
{
    public int getGoldwert();
    public void SetGoldwert(int goldwert);

    static Schatzkarte getRandomSchatzkarte() {
        int count = Inventar.getSchatzkartenList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getSchatzkartenList().get(randomCardIndex);
    }
}
