package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Player;

public class LvlUpKarte extends SchatzkarteImpl {

    public LvlUpKarte(int image) {
        super(image, 0);    //Konstruktor von SchatzkarteImpl aufrufen
                                    // Goldwert muss 0 sein
    }

    public void triggerPlayerLvlIncrease(){
        Player.getLocalPlayer().getPlayerLevel().levelIncrease();
    }

}
