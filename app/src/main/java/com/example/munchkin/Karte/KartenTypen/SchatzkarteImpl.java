package com.example.munchkin.Karte.KartenTypen;

public class SchatzkarteImpl implements Schatzkarte {
    //Please DONT use this Konstruktor - it is needed for Networking
    public SchatzkarteImpl(){}

    //Variablen
    private int goldwert;
    private int image;


    //Konstruktor
    public SchatzkarteImpl(int image, int goldwert){
        this.image = image;
        this.goldwert= goldwert;
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
    public int getGoldwert() {
        return goldwert;
    }

}
