package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Player;

public class LvlUpKarte extends SchatzkarteImpl {
    private int goldwert;
    private int image;

    public LvlUpKarte()
    {
        setImage(image);
        this.goldwert = 0; //Goldwert muss 0 sein
    }

    public void triggerPlayerLvlIncrease(){
        Player.getLocalPlayer().getPlayerLevel().levelIncrease();
    }

}
