package com.example.munchkin.Karte.KartenTypen;


public class LvlUpKarte extends SchatzkarteImpl {
    private int goldwert;
    private int image;

    public LvlUpKarte()
    {
        setImage(image);
        goldwert = 0; //Goldwert muss 0 sein
    }


    //Übernommen von LvlUpCards

    public int increaceLvlByOnePermanet(int currentLevel) {
        currentLevel++;
        return currentLevel;
    }
}
