package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.GamePhase;
import com.example.munchkin.Kampf;
import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
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
        if(GamePhase.getPhase() != GamePhase.Phase.vorbereitungsPhase || !Player.getLocalPlayer().getIstDran())
            return;

        Karte gehobeneKarte = getKarte();
        gehobeneKarte.onKarteGehoben();

        if(gehobeneKarte instanceof Monsterkarte)
        {
            Spielfeld.getMonsterKartenSlot().karteAblegen(gehobeneKarte);
            GameClient.sendMonsterKarteGelegtAnServer(gehobeneKarte);
            new Kampf(Player.getLocalPlayer(), (Monsterkarte)gehobeneKarte);
        }
        else
        {
            Player.getLocalPlayer().getInventar().getHandKarten().addKarte(gehobeneKarte);
        }
    }
}
