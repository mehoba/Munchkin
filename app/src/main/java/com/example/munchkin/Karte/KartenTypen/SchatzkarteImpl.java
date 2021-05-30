package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KarteImpl;

import java.util.Random;

public class SchatzkarteImpl implements Schatzkarte
{
    int goldwert;
    private int image;

    @Override
    public int getImage() {
        return image;
    }
    @Override
    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int getGoldwert() {
        return goldwert;
    }
    @Override
    public void SetGoldwert(int goldwert) {
        this.goldwert = goldwert;
    }
}
