package com.example.munchkin.Karte;

import android.widget.ImageView;

public class KartenSlot
{
    private Karte karte;
    private ImageView kartenImageView;

    public KartenSlot(ImageView kartenImageView)
    {
        this.kartenImageView = kartenImageView;
    }

    public Karte getKarte() {
        return karte;
    }
    private void setKarte(Karte karte)
    {
        //ToDo Implement UI Stuff
    }

    public void MoveCard(KartenSlot destination)
    {
        destination.setKarte(karte);
        karte = null;
        kartenImageView.setImageDrawable(null);
    }
}
