package com.example.munchkin.Karte.KartenTypen;


public class LvlUpKarteImpl implements LevelUpKarte
{
    private int goldwert;
    private int image;

    public LvlUpKarteImpl()
    {
        setImage(image);
        goldwert = 0; //Goldwert muss 0 sein
    }

    @Override
    public int getGoldwert() {
        return goldwert;
    }

    @Override
    public void SetGoldwert(int goldwert) {
        this.goldwert=goldwert;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }

    //Übernommen von LvlUpCards
    @Override
    public int increaceLvlByOnePermanet(int currentLevel) {
        currentLevel++;
        return currentLevel;
    }
}
