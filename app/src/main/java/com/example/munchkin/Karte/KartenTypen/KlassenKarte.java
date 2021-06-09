package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.CardType;

public class KlassenKarte extends TürkarteImpl {
    //Please DONT use this Konstruktor - it is needed for Networking
    public KlassenKarte(){}

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
    public KlassenKarte(int image){
       super(image);
       setCardType(CardType.KLASSENKARTE);
    }

}
