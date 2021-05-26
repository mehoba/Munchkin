package com.example.munchkin;

import android.telephony.RadioAccessSpecifier;

import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.KlassenKarte;
import com.example.munchkin.Karte.RassenKarte;

public class Player
{
    private String name;
    private int connectionId;
    private int playerBoardNumber;//Aufsteigend von 0 - 3. Bestimmt Platz am Board
    //ToDo Player Icon
    //ToDo setPlayerName()
    private Inventar inventar;
    private Level playerLevel;


    public Player()
    {
        //ToDo Parameter beim Level ????
        playerLevel = new Level(null);//<-------------------------------------------------- Fehlt etwas beim Parameter
        inventar = new Inventar();
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
