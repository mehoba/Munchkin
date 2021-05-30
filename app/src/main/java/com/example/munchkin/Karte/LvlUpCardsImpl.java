package com.example.munchkin.Karte;

public class LvlUpCardsImpl implements LvlUpCards {
    private int image;
    private int Goldwert;

    public LvlUpCardsImpl(int image){
        setImage(image);
    }
    @Override
    public int increaceLvlByOnePermanet(int currentLevel) {
        currentLevel++;
        return currentLevel;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
this.image=image;
    }
}
