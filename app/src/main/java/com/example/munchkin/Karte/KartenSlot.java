package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

public class KartenSlot
{
    private Karte karte;
    private ImageView imgKarte;

    public KartenSlot(ImageView kartenImageView)
    {
        //For Tests
        if(kartenImageView != null)
            this.imgKarte = kartenImageView;
        karte = null;
    }

    public Karte getKarte()
    {
        return karte;
    }

    public void karteAblegen(Karte karte)
    {
        if(karte == null) return;

        imgKarte.setImageResource(karte.getImage());
        imgKarte.setVisibility(View.VISIBLE);
        this.karte = karte;
    }

    public Karte karteHeben()
    {
        if(karte == null) return null;

        Karte tempKarte = karte;
        imgKarte.setImageDrawable(null);
        karte = null;
        return tempKarte;
    }

    public ImageView getImgKarte()
    {
        return imgKarte;
    }
}
