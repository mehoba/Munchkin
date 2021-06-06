package com.example.munchkin.Karte.KartenTypen;

public class SchatzkarteImpl implements Schatzkarte {
    private int goldwert;
    private int image;

    public SchatzkarteImpl(int image, int goldwert){
        this.image = image;
        this.goldwert= goldwert;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public int getGoldwert() {
        return goldwert;
    }

}
