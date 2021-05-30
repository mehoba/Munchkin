package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.KarteImpl;

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
