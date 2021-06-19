package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Player;
import com.example.munchkin.Rasse;

public class RassenKarte extends TürkarteImpl{
    private Rasse rasse;

    //Please DONT use this Konstruktor - it is needed for Networking
    public RassenKarte(){}



    //Konstruktor
    public RassenKarte(int image, Rasse rasse){
        super(image);
        this.rasse = rasse;
    }

    //Methoden

    public Rasse getRasse() {
        return this.rasse;
    }

    @Override
    public void onkarteAusgespielt() {
        super.onkarteAusgespielt();
        Player.getLocalPlayer().onRassenkarte(this);
    }
}
