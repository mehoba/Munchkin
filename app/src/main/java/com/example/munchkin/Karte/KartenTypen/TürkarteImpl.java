package com.example.munchkin.Karte.KartenTypen;

public class TürkarteImpl implements Türkarte {

    private int image;

    public TürkarteImpl(int image){
        this.image = image;
    }

    @Override
    public int getImage() {
        return image;
    }

}
