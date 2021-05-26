package com.example.munchkin.Karte;

import android.widget.ImageView;

import com.example.munchkin.R;
import com.example.munchkin.SpielfeldActivity;

import java.security.PublicKey;
import java.util.LinkedList;
import java.util.List;

public class HandKarten
{
    SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();

    private KartenSlot[] kartenSlots;
    int anzahlInHand = 0;

    public HandKarten()
    {
        kartenSlots = new KartenSlot[4];
        kartenSlots[0] = new KartenSlot(spielfeldActivity.findViewById(R.id.cardView));
        kartenSlots[1] = new KartenSlot(spielfeldActivity.findViewById(R.id.cardView2));
        kartenSlots[2] = new KartenSlot(spielfeldActivity.findViewById(R.id.cardView3));
        kartenSlots[3] = new KartenSlot(spielfeldActivity.findViewById(R.id.cardView4));
    }

    public KartenSlot getKarte(int index)
    {
        return kartenSlots[index];
    }

    public KartenSlot getEmptyKardSlot()
    {
        if(kartenSlotsNotFull())
        {
            //Todo Implement

        }
        return null;
    }

    public boolean kartenSlotsNotFull()
    {
        if(anzahlInHand >= 4)
        {
            return false;
        }
        return true ;
    }



    public List<Karte> getHandKarten() {
        return handKarten;
    }

    public void setHandKarten(List<Karte> handKarten) {
        this.handKarten = handKarten;
    }

    private List<Karte> handKarten;

    public boolean checkIfMoreThan7(){

        if(getHandKarten().size() >7)
            return true;
        else return false;
    }
}
