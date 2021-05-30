package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.Karte.KartenTypen.Türkarte;
import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Player;
import com.example.munchkin.Spielfeld;

public class TürkartenStapel extends KartenSlot {

    public TürkartenStapel(ImageView kartenImageView) {
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
                onTürkartenStapelClicked();
            }
        });
    }

    @Override
    public Karte getKarte()
    {
        return Türkarte.getRandomTürkarte();
    }

    void onTürkartenStapelClicked()//Todo heben implementieren
    {
        Karte gehobeneKarte = getKarte();
        Spielfeld.getKartenSlotUntenLinks().karteAblegen(gehobeneKarte);
        GameClient.SendMonsterKarteGelegtAnServer(gehobeneKarte);
    }
}
