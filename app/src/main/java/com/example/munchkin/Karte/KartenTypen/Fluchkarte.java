package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class Fluchkarte extends TürkarteImpl {

    private int amountLostLevel;

//    Konstruktor
    public Fluchkarte(int image, int amountLostLevel){
        super(image);
        this.amountLostLevel=amountLostLevel;
    }

    public int getAmountLostLevel(){
        return amountLostLevel;
    }



/*    //Für Fluchkarten, die Ausrüstung betreffen
    private BodyPart bodyPart;

    //    Konstruktor
    public Fluchkarte(int image, BodyPart bodyPart){
        super(image);
        this.bodyPart=bodyPart;
    }

    //Übernommen von FluchCardsImpl
    public void loseArmor(BodyPart bodyPart, int size) {
        //TODO Funktionalität implementieren
    }
    */
}
