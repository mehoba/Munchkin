package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

public class KartenSlot
{
    private Karte karte;
    private ImageView imgKarte;

    public KartenSlot(ImageView imgKarte)
    {
        //For Tests
        this.imgKarte = imgKarte;

        karte = null;
    }

    public Karte getKarte()
    {
        return karte;
    }

    public void karteAblegen(Karte karte)
    {
        if(karte == null) return;

        //For Tests
        if(imgKarte != null)
        {
            imgKarte.setImageResource(karte.getImage());
            imgKarte.setVisibility(View.VISIBLE);
        }

        this.karte = karte;
    }

    public Karte karteHeben()
    {
        if(karte == null) return null;


        Karte tempKarte = karte;
        //For Tests
        if(imgKarte != null)
        {
            imgKarte.setImageDrawable(null);
        }
        karte = null;
        return tempKarte;
    }

    public ImageView getImgKarte()
    {
        return imgKarte;
    }
    //Pls only set in the initializeUIFunction
    public void setImgKarte(ImageView imgKarte)
    {
        this.imgKarte = imgKarte;
    }
}
