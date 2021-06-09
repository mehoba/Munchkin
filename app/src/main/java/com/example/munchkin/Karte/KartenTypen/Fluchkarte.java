package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;
import com.example.munchkin.Karte.CardType;

public class Fluchkarte extends TürkarteImpl {
    //Please DONT use this Konstruktor - it is needed for Networking
    public Fluchkarte(){}

    private CardType cardType;

    @Override
    public void setCardType(CardType cardType) {
        this.cardType= cardType;
    }

    @Override
    public CardType getCardType() {
        return  cardType;
    }

    //Variablen
    private int amountLostLevel;

    //Konstruktor
    public Fluchkarte(int image, int amountLostLevel){
        super(image);
        this.amountLostLevel=amountLostLevel;
        setCardType(CardType.FLUCHKARTE);
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
