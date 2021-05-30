package com.example.munchkin.Karte;


import java.util.Random;

public class KarteImpl implements Karte {

   // private CardType cardType;
    public int image;

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }
}
