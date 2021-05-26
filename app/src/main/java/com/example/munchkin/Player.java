package com.example.munchkin;

import android.telephony.RadioAccessSpecifier;

import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.KlassenKarte;
import com.example.munchkin.Karte.RassenKarte;

public class Player
{
    private String name;
    private int connectionId;
    private int playerBoardNumber;//Aufsteigend von 0 - 3. Bestimmt Platz am Board

    private HandKarten handKarten;
    private Level playerLevel;
    private PlayerAusrüstung playerAusrüstung;
    private KlassenKarte klassenKarte;
    private RassenKarte rassenKarte;

    public Player()
    {
        handKarten = new HandKarten();

        playerLevel = new Level(null  );//<-------------------------------------------------- Fehlt etwas beim Parameter

        playerAusrüstung = new PlayerAusrüstung();
        klassenKarte = new KlassenKarte();
        rassenKarte = new RassenKarte();
    }

    //---------Getter/Setter-----------
    public int getPlayerBoardNumber() {
        return playerBoardNumber;
    }

    public void setPlayerBoardNumber(int playerBoardNumber) {
        this.playerBoardNumber = playerBoardNumber;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //-----------------------------------



}
