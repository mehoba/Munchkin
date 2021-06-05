package com.example.munchkin.Karte.KartenTypen;


public class LvlUpKarte implements Schatzkarte {
    private int goldwert;
    private int image;

    public LvlUpKarte()
    {
        setImage(image);
        goldwert = 0; //Goldwert muss 0 sein
    }


    public int getGoldwert() {
        return goldwert;
    }


    public void SetGoldwert(int goldwert) {
        this.goldwert=goldwert;
    }


    public int getImage() {
        return image;
    }


    public void setImage(int image) {
        this.image=image;
    }

    //Übernommen von LvlUpCards

    public int increaceLvlByOnePermanet(int currentLevel) {
        currentLevel++;
        return currentLevel;
    }
}
