package com.example.munchkin.Karte.KartenTypen;

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
