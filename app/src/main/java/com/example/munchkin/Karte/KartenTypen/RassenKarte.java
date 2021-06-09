package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.CardType;

public class RassenKarte extends TürkarteImpl{
    //Please DONT use this Konstruktor - it is needed for Networking
    public RassenKarte(){}

    private CardType cardType;

    @Override
    public void setCardType(CardType cardType) {
        this.cardType= cardType;
    }

    @Override
    public CardType getCardType() {
        return  cardType;
    }

    //Konstruktor
    public RassenKarte(int image){
        super(image);
        setCardType(CardType.RASSENKARTE);
    }

    //Methoden

    public void addBonus() {
        //TODO: Funktionalität Implementieren
    }

}
