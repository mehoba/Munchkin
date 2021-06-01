package com.example.munchkin.Karte.KartenTypen;

public class RassenKarteImpl implements RassenKarte
{
    private int image;

    @Override
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
