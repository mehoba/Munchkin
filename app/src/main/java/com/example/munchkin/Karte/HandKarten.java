package com.example.munchkin.Karte;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.munchkin.Activity.CardPopActivity_handkarten;
import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Player;
import com.example.munchkin.Activity.SpielfeldActivity;

import java.util.ArrayList;
import java.util.List;

public class HandKarten
{
    private SpielfeldActivity spielfeldActivity;
    private final List<KartenSlot> karten;

    public HandKarten()
    {
        karten = new ArrayList<>();
    }

    public void initializeUIConnection()
    {
        spielfeldActivity = SpielfeldActivity.getInstance();
    }

    void onKartenSlotClicked(KartenSlot slot)
    {
        //Todo istDran temporär deaktiviert zum zeigen
        if(/*!Player.istDranAktiviert ||*/ Player.getLocalPlayer().getIstDran())
        {
            CardPopActivity_handkarten.show(slot, this);
            //Spielfeld.getAusgespielteKartenSlot().karteAblegen(gehobeneKarte);
            //GameClient.sendKarteAufAbgelegtStapelGelegt(gehobeneKarte);
        }
    }

    //Added eine neue Karte an eine freie Handkarten Position
    public void addKarte(Karte karte)
    {
        ImageView imageView = new ImageView(spielfeldActivity.getBaseContext());
        imageView.setImageResource(karte.getImage());
        KartenSlot kartenSlot = new KartenSlot(imageView);
        kartenSlot.karteAblegen(karte);
        imageView.setOnClickListener(view -> onKartenSlotClicked(kartenSlot));
        spielfeldActivity.handcardLayout.addView(imageView, new ViewGroup.LayoutParams(154, 200));
        karten.add(kartenSlot);
    }

    public  void addKarte(Karte[] karten)
    {
        for(int i = 0; i < karten.length; i++)
        {
            ImageView imageView = new ImageView(spielfeldActivity.getBaseContext());
            imageView.setImageResource(karten[i].getImage());
            KartenSlot kartenSlot = new KartenSlot(imageView);
            kartenSlot.karteAblegen(karten[i]);
            imageView.setOnClickListener(view -> onKartenSlotClicked(kartenSlot));
            spielfeldActivity.handcardLayout.addView(imageView, new ViewGroup.LayoutParams(154, 200));
            this.karten.add(kartenSlot);
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

            while(countHandkarten() > 5) {
                if(lowestPlayer.equals(Player.getLocalPlayer())) {
                    // We are the lowest player so move card to ablage
                    this.removeKarte(5);
                } else {
                    // Give card to player with lowest level
                    GameClient.sendKarteZuSpieler(this.removeKarte(5), lowestPlayer);

                }
            }
        }
    }

    public Karte removeKarte(int index)
    {
        View v = spielfeldActivity.handcardLayout.getChildAt(index);
        spielfeldActivity.handcardLayout.removeView(v);
        return karten.remove(index).getKarte();
    }

    public Karte removePlayedKarte()
    {
        boolean found = false;
        int i;
        for(i = 0; i < karten.size(); ++i) {
            if(karten.get(i).getKarte() == null) {
                found = true;
                break;
            }
        }
        if(found) {
            return removeKarte(i);
        } else {
            return removeKarte(0);
        }
    }

    public boolean checkIfNotMoreThan4()
    {
        if(countHandkarten() >= 4)
        {
            return false;
        }
        return true;
    }

    public int countHandkarten()
    {
        return karten.size();
    }
}
