package com.example.munchkin.Karte;

import android.view.View;

import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Player;
import com.example.munchkin.Spielfeld;
import com.example.munchkin.Activity.SpielfeldActivity;

import java.util.Arrays;

public class HandKarten
{
    private final KartenSlot[] kartenSlots;

    public HandKarten()
    {
        kartenSlots = new KartenSlot[7];

        //For Testing null
        for(int i = 0; i < kartenSlots.length; ++i) {
            kartenSlots[i] = new KartenSlot(null);
        }
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
        //Todo istDran temporär deaktiviert zum zeigen
        if(!Player.istDranAktiviert || Player.getLocalPlayer().getIstDran())
        {
            Karte gehobeneKarte = kartenSlots[i].karteHeben();
            Spielfeld.getAusgespielteKartenSlot().karteAblegen(gehobeneKarte);
            GameClient.sendKarteAufAbgelegtStapelGelegt(gehobeneKarte);
        }
    }

    //Added eine neue Karte an eine freie Handkarten Position
    public void addKarte(Karte karte)
    {
        if(countHandkarten() < 7)
            getNextEmptySlot().karteAblegen(karte);
    }

    public  void addKarte(Karte[] karten)
    {
        for(int i = 0; i < karten.length; i++)
        {
            if(countHandkarten() < 7)
                getNextEmptySlot().karteAblegen(karten[i]);
        }
    }

    //TODO: Should be called when the player finishes his round
    public void onFinishRound() {
        // Only up to 5 Cards are allowed
        if(countHandkarten() > 5) {
            int playerLevel = Player.getLocalPlayer().getPlayerLevel().getLevel();
            Player lowestPlayer = Player.getLocalPlayer();
            int currentLowest = playerLevel;
            for(int i = 0; i < Lobby.getPlayers().length; ++i) {
                if(Lobby.getPlayers()[i] != null && Lobby.getPlayers()[i].getPlayerLevel().getLevel() < currentLowest) {
                    lowestPlayer = Lobby.getPlayers()[i];
                    currentLowest = Lobby.getPlayers()[i].getPlayerLevel().getLevel();
                }
            }

            for(int i = 5; i < kartenSlots.length; ++i) {
                if(lowestPlayer.equals(Player.getLocalPlayer())) {
                    // We are the lowest player so move card to ablage
                    this.removeKarte(i);
                } else {
                    // Give card to player with lowest level
                    lowestPlayer.getInventar().getHandKarten().addKarte(this.removeKarte(i));
                }
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

    public int countHandkarten()
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
