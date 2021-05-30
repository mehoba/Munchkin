package com.example.munchkin.Karte;

import android.view.View;

import com.example.munchkin.Player;
import com.example.munchkin.Spielfeld;
import com.example.munchkin.Activity.SpielfeldActivity;

public class HandKarten
{
    private final KartenSlot[] kartenSlots;

    public HandKarten()
    {
        kartenSlots = new KartenSlot[4];

        //For Testing
        kartenSlots[0] = new KartenSlot(null);
        kartenSlots[1] = new KartenSlot(null);
        kartenSlots[2] = new KartenSlot(null);
        kartenSlots[3] = new KartenSlot(null);
    }

    public void initializeUIConnection()
    {
        SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();

        kartenSlots[0].setImgKarte(spielfeldActivity.imgCardView);
        kartenSlots[1].setImgKarte(spielfeldActivity.imgCardView2);
        kartenSlots[2].setImgKarte(spielfeldActivity.imgCardView3);
        kartenSlots[3].setImgKarte(spielfeldActivity.imgCardView4);

        kartenSlots[0].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlotClicked(0);
            }
        });
        kartenSlots[1].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlotClicked(1);
            }
        });
        kartenSlots[2].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlotClicked(2);
            }
        });
        kartenSlots[3].getImgKarte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onKartenSlotClicked(3);
            }
        });
    }

    void onKartenSlotClicked(int i)
    {
        if(Player.getLocalPlayer().getIstDran())
        {
            Spielfeld.getKartenSlotUntenLinks().karteAblegen(kartenSlots[i].karteHeben());
        }
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
