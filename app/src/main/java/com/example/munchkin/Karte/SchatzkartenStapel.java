package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.GamePhase;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Player;

public class SchatzkartenStapel extends KartenSlot {
    private static int anzahlErlaubtesZiehen = 0;

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
        if(GamePhase.getPhase() != GamePhase.Phase.vorbereitungsPhase || !Player.getLocalPlayer().getIstDran())
            return;

        if(getAnzahlErlaubtesZiehen() <= 0)
            return;

        Karte gehobeneKarte = getKarte();
        gehobeneKarte.onKarteGehoben();
        Player.getLocalPlayer().getInventar().getHandKarten().addKarte(gehobeneKarte);

        setAnzahlErlaubtesZiehen(getAnzahlErlaubtesZiehen()-1);
    }


    public static int getAnzahlErlaubtesZiehen() {
        return anzahlErlaubtesZiehen;
    }

    public static void setAnzahlErlaubtesZiehen(int anzahlErlaubtesZiehen) {
        SchatzkartenStapel.anzahlErlaubtesZiehen = anzahlErlaubtesZiehen;

        if(SpielfeldActivity.getInstance().txtZiehenSchatzkartenStapel != null) {
            String anzahl = String.valueOf(anzahlErlaubtesZiehen);
            SpielfeldActivity.getInstance().txtZiehenSchatzkartenStapel.setText(anzahl);
        }
        else {
            System.out.println("Ein Fehler ist aufgetreten beim Versuch auf ein Textfeld in SpielfeldActivity zuzugreifen");
        }
    }
}
