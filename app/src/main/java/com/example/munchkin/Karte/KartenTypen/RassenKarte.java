package com.example.munchkin.Karte.KartenTypen;

public class RassenKarte implements Türkarte
{
    private int image;


    public void addBonus() {
        //TODO: Funktionalität Implementieren
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }
}
