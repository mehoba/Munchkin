package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class Fluchkarte implements Türkarte {
    private int image;

    //Übernommen von FluchCardsImpl
    private int lostLevel;
    private BodyPart bodyPart;

//    Konstruktor aus FluchCardsImpl
//    public FluchCardsImpl(int image, int lostLevel, BodyPart bodyPart){
//        setImage(image);
//        this.lostLevel=lostLevel;
//        this.bodyPart=bodyPart;
//
//    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }

    //Übernommen von FluchCardsImpl

    public void loseArmor(BodyPart bodyPart, int size) {
    }

    public void loseLevel(int currentLvl) {
        currentLvl-= lostLevel;
    }
}
