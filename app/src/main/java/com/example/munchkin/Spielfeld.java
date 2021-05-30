package com.example.munchkin;

import android.widget.ImageView;

import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Karte.SchatzkartenStapel;
import com.example.munchkin.Karte.TürkartenStapel;

public class Spielfeld {
    private static Spielfeld instance;
    private final TürkartenStapel türkartenStapel;
    private final SchatzkartenStapel schatzkartenStapel;

    private final KartenSlot kartenSlot;

    public Spielfeld()
    {
        instance = this;

        türkartenStapel = new TürkartenStapel(null);
        schatzkartenStapel = new SchatzkartenStapel(null);
        kartenSlot = new KartenSlot(null);
    }

    public void initializeUiConnection()
    {
        SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();

        türkartenStapel.setImgKarte(spielfeldActivity.imgdoorcard);
        schatzkartenStapel.setImgKarte(spielfeldActivity.imgSchatzkarte);
        kartenSlot.setImgKarte(spielfeldActivity.imgMidemptycard_bottomleft);
    }

    public static TürkartenStapel getTürkartenStapel() {
        return instance.türkartenStapel;
    }

    public static SchatzkartenStapel getSchatzkartenStapel() {
        return instance.schatzkartenStapel;
    }

    public static KartenSlot getKartenSlotUntenLinks() {
        return instance.kartenSlot;
    }
}
