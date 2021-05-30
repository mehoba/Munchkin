package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.KarteImpl;

public class KlassenKarteImpl implements KlassenKarte {
    private int image;

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }
}
