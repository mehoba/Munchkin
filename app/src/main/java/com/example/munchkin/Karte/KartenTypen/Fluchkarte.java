package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class Fluchkarte extends TürkarteImpl {
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


    //Übernommen von FluchCardsImpl

    public void loseArmor(BodyPart bodyPart, int size) {
    }

    public void loseLevel(int currentLvl) {
        currentLvl-= lostLevel;
    }
}
