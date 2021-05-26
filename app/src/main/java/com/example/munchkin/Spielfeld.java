package com.example.munchkin;

import com.example.munchkin.Karte.TürkartenStapel;

public class Spielfeld {
    private static Spielfeld instance;
    private static TürkartenStapel türkartenStapel;

    public Spielfeld()
    {
        SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();
        instance = this;
        türkartenStapel = new TürkartenStapel(spielfeldActivity.findViewById(R.id.spielfeldui_doorcard));
    }

    public static Spielfeld getInstance() {
        return instance;
    }
}
