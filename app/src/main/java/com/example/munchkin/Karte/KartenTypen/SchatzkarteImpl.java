package com.example.munchkin.Karte.KartenTypen;

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
