package com.example.munchkin;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Karte.SchatzkartenStapel;
import com.example.munchkin.Karte.TürkartenStapel;

public class Spielfeld {
    private static Spielfeld instance;
    private final TürkartenStapel türkartenStapel;
    private final SchatzkartenStapel schatzkartenStapel;

    private final KartenSlot monsterKartenSlot;
    private final KartenSlot ausgespielteKartenSlot;
    private final KartenSlot ablageStapelSchatzkartenSlot;
    private final KartenSlot ablageStapelTürkartenSlot;

    public Spielfeld()
    {
        instance = this;

        türkartenStapel = new TürkartenStapel(null);
        schatzkartenStapel = new SchatzkartenStapel(null);
        monsterKartenSlot = new KartenSlot(null);
        ausgespielteKartenSlot = new KartenSlot(null);
        ablageStapelSchatzkartenSlot = new KartenSlot(null);
        ablageStapelTürkartenSlot = new KartenSlot(null);
    }

    public void initializeUiConnection()
    {
        SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();

        türkartenStapel.setImgKarte(spielfeldActivity.imgdoorcard);
        schatzkartenStapel.setImgKarte(spielfeldActivity.imgSchatzkarte);
        monsterKartenSlot.setImgKarte(spielfeldActivity.imgMonsterKartenSlot);
        ausgespielteKartenSlot.setImgKarte(spielfeldActivity.imgAusgespielteKartenSlot);
        ablageStapelSchatzkartenSlot.setImgKarte(spielfeldActivity.ablageStapelSchatzkarten);
        ablageStapelTürkartenSlot.setImgKarte(spielfeldActivity.ablageStapelTürkarten);
    }

    public static TürkartenStapel getTürkartenStapel() {
        return instance.türkartenStapel;
    }

    public static SchatzkartenStapel getSchatzkartenStapel() {
        return instance.schatzkartenStapel;
    }

    public static KartenSlot getMonsterKartenSlot() {
        return instance.monsterKartenSlot;
    }
    public static KartenSlot getAusgespielteKartenSlot() {
        return instance.ausgespielteKartenSlot;
    }
    public static KartenSlot getAblageStapelTürkartenSlot() {
        return instance.ablageStapelTürkartenSlot;
    }
    public static KartenSlot getAblageStapelSchatzkartenSlot() {
        return instance.ablageStapelSchatzkartenSlot;
    }
}
