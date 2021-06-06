package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class Fluchkarte extends TürkarteImpl {
    //Please DONT use this Konstruktor - it is needed for Networking
    public Fluchkarte(){}

    //Variablen
    private int amountLostLevel;

    //Konstruktor
    public Fluchkarte(int image, int amountLostLevel){
        super(image);
        this.amountLostLevel=amountLostLevel;
    }

    //Methoden

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
