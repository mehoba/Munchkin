package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Karte.KartenTypen.SchatzkarteImpl;
import com.example.munchkin.Player;

public class SchatzkartenStapel extends KartenSlot
{
    public SchatzkartenStapel(ImageView kartenImageView) {
        super(kartenImageView);
    }

    @Override
    public void setImgKarte(ImageView imgKarte) {
        super.setImgKarte(imgKarte);
        initializeUiConnection();
    }

    private void initializeUiConnection()
    {
        getImgKarte().setOnClickListener(new View.OnClickListener() {
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
        Karte gehobeneKarte = getKarte();
        gehobeneKarte.onKarteGehoben();
        Player.getLocalPlayer().getInventar().getHandKarten().addKarte(gehobeneKarte);
    }
}
