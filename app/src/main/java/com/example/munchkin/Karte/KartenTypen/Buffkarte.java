package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Player;

public class Buffkarte extends SchatzkarteImpl{

    //Please DONT use this Konstruktor - it is needed for Networking
    public Buffkarte(){}

    //Variablen
    private int amountBonus;

    //Konstruktor aus BuffCardsImpl
    public Buffkarte(int image, int goldwert, int amountBonus){
        super(image, goldwert);

        //Statt set wird nun direkt in Konstruktor gesetzt, da nachträglich nicht veränderbar sein sollte
        this.amountBonus = amountBonus;
    }

//    //Idee zu sagen für welche seite gespielt wird
//    public void gespieltFür(Monsterkarte monsterkarte oder Player player){
//
//    }






}
