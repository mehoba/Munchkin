package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.CardType;

public class TürkarteImpl implements Türkarte {
    //Please DONT use this Konstruktor - it is needed for Networking
    public TürkarteImpl(){}

    //Variable
    private int image;

    //Konstruktor
    public TürkarteImpl(int image){
        this.image = image;
    }

    //Methoden
    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void onKarteGehoben() {

    }

    @Override
    public void onkarteAusgespielt() {

    }

    @Override
    public CardType getCardType() {
        return null;
    }

    @Override
    public void setCardType(CardType cardType) {

    }

}
