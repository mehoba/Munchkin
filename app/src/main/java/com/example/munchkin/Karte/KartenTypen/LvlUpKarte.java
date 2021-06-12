package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Player;
import com.example.munchkin.Spielfeld;

public class LvlUpKarte extends SchatzkarteImpl {
    //Please DONT use this Konstruktor - it is needed for Networking
    public LvlUpKarte(){}


    //Konstruktor
    public LvlUpKarte(int image) {
        super(image, 0);    //Konstruktor von SchatzkarteImpl aufrufen
                                    // Goldwert muss 0 sein

    }

    @Override
    public void onkarteAusgespielt() {
        super.onkarteAusgespielt();
        triggerPlayerLvlIncrease();

    }

    //Methoden
    public void triggerPlayerLvlIncrease(){
        Player.getLocalPlayer().getPlayerLevel().levelIncrease();
    }


}
