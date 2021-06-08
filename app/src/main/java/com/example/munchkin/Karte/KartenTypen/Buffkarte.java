package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Karte.CardType;
import com.example.munchkin.Player;

public class Buffkarte extends SchatzkarteImpl{
    private CardType cardType;

    //Please DONT use this Konstruktor - it is needed for Networking
    public Buffkarte(){}

    @Override
    public void setCardType(CardType cardType) {
        this.cardType= cardType;
    }

    @Override
    public CardType getCardType() {
        return  cardType;
    }

    //Variablen
    private int amountBonus;

    //Konstruktor aus BuffCardsImpl
    public Buffkarte(int image, int goldwert, int amountBonus){
        super(image, goldwert);
        setCardType(CardType.BUFF);

        //Statt set wird nun direkt in Konstruktor gesetzt, da nachträglich nicht veränderbar sein sollte
        this.amountBonus = amountBonus;
    }

//    //Idee zu sagen für welche seite gespielt wird
//    public void gespieltFür(Monsterkarte monsterkarte oder Player player){
//
//    }






}
