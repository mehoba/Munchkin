package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Player;

public class SchatzkartenStapel extends KartenSlot
{
    public SchatzkartenStapel(ImageView kartenImageView) {
        super(kartenImageView);
        kartenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSchatzkartenStapelClicked();
            }
        });
    }

    @Override
    public Karte getKarte()
    {
        return Schatzkarte.getRandomSchatzkarte();
    }


    void onSchatzkartenStapelClicked()
    {
        Player.getLocalPlayer().getInventar().getHandKarten().addKarte(getKarte());
    }
}
