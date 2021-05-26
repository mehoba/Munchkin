package com.example.munchkin.Karte;

import android.widget.ImageView;

public class TürkartenStapel extends KartenSlot {

    public TürkartenStapel(ImageView kartenImageView) {
        super(kartenImageView);
    }

    @Override
    public Karte getKarte()
    {
        return Inventar.getRandomDoorCard();
    }
}
