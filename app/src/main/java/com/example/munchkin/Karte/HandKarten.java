package com.example.munchkin.Karte;

import android.view.View;

import com.example.munchkin.Spielfeld;
import com.example.munchkin.SpielfeldActivity;

public class HandKarten
{
    private final SpielfeldActivity spielfeldActivity;
    private KartenSlot[] kartenSlots;

    public HandKarten()
    {
        spielfeldActivity = SpielfeldActivity.getInstance();

        kartenSlots = new KartenSlot[4];
        kartenSlots[0] = new KartenSlot(spielfeldActivity.imgCardView);
        kartenSlots[0].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlot0Clicked();
            }
        });
        kartenSlots[1] = new KartenSlot(spielfeldActivity.imgCardView2);
        kartenSlots[1].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlot1Clicked();
            }
        });
        kartenSlots[2] = new KartenSlot(spielfeldActivity.imgCardView3);
        kartenSlots[2].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlot2Clicked();
            }
        });
        kartenSlots[3] = new KartenSlot(spielfeldActivity.imgCardView4);
        kartenSlots[3].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlot3Clicked();
            }
        });
    }

    void onKartenSlot0Clicked()
    {
        Spielfeld.getKartenSlotUntenLinks().karteAblegen(kartenSlots[0].karteHeben());
    }
    void onKartenSlot1Clicked()
    {
        Spielfeld.getKartenSlotUntenLinks().karteAblegen(kartenSlots[1].karteHeben());
    }
    void onKartenSlot2Clicked()
    {
        Spielfeld.getKartenSlotUntenLinks().karteAblegen(kartenSlots[2].karteHeben());
    }
    void onKartenSlot3Clicked()
    {
        Spielfeld.getKartenSlotUntenLinks().karteAblegen(kartenSlots[3].karteHeben());
    }

    //Added eine neue Karte an eine freie Handkarten Position
    public void addKarte(Karte karte)
    {
        if(checkIfNotMoreThan4())
            getNextEmptySlot().karteAblegen(karte);
    }

    public  void addKarte(Karte[] karten)
    {
        for(int i = 0; i < karten.length; i++)
        {
            if(checkIfNotMoreThan4())
            {
                getNextEmptySlot().karteAblegen(karten[i]);
            }
        }
    }

    public Karte removeKarte(int index)
    {
        return kartenSlots[index].karteHeben();
    }

    public KartenSlot getNextEmptySlot()
    {
        for(int i = 0; i < kartenSlots.length; i++)
        {
            if(kartenSlots[i].getKarte() == null)
            {
                return kartenSlots[i];
            }
        }
        return null;
    }

    public boolean checkIfNotMoreThan4()
    {
        if(countHandkarten() >= 4)
        {
            return false;
        }
        return true;
    }

    private Karte getKarte(int index)
    {
        return kartenSlots[index].getKarte();
    }

    private int countHandkarten()
    {
        int count = 0;
        for(int i = 0; i < kartenSlots.length; i++)
        {
            if(kartenSlots[i].getKarte() != null)
            {
                count++;
            }
        }
        return count;
    }
}
