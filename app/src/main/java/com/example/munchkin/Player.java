package com.example.munchkin;

import com.example.munchkin.Karte.Inventar;

public class Player
{
    private static Player localPlayer;

    private String name;
    private int connectionId;
    private int playerBoardNumber;//Aufsteigend von 0 - 3. Bestimmt Platz am Board
    //ToDo Player Icon
    //ToDo setPlayerName()
    private Inventar inventar;
    private Level playerLevel;
    private Boolean istDran;

    //Only call when Spielfeld is completely loaded
    public void initializePlayer()
    {
        //ToDo Parameter beim Level ????
        //playerLevel = new Level(null);//<-------------------------------------------------- Fehlt etwas beim Parameter
        playerLevel = null;
        inventar = new Inventar();
        istDran = false;
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

    public  static  Player getLocalPlayer()
    {
        return  localPlayer;
    }

    //Bitte nur am Anfang des Spiels in der Main Activity setzen!!!!
    public static void setLocalPlayer(Player localPlayer) {
        Player.localPlayer = localPlayer;
    }

    public Inventar getInventar()
    {   return  inventar;   }

    public Boolean getIstDran() {
        return istDran;
    }

    public void setIstDran(Boolean istDran) {
        this.istDran = istDran;
        //Todo lock or unlock player
    }
    //-----------------------------------



}
