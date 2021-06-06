package com.example.munchkin.Karte.KartenTypen;

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

}
