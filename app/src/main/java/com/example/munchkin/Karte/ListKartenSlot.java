package com.example.munchkin.Karte;

import android.widget.ImageView;

public class ListKartenSlot extends KartenSlot
{
    private final HandKarten handKarten;
    private int listIndex;

    public  ListKartenSlot(ImageView imgKarte, HandKarten handKarten)
    {
        super(imgKarte);
        this.handKarten = handKarten;
    }

    @Override
    public Karte karteHeben() {
        Karte gehobeneKarte = super.karteHeben();
        getHandKarten().removeKarte(getListIndex());
        return gehobeneKarte;
    }

    public HandKarten getHandKarten() {
        return handKarten;
    }

    public int getListIndex() {
        return listIndex;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }
}
