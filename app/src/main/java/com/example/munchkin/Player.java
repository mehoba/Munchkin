package com.example.munchkin;

import com.example.munchkin.Karte.Inventar;

public class Player extends PlayerData
{
    private static Player localPlayer;

    private PlayerAusrüstung playerAusrüstung;

    //ToDo Player Icon
    //ToDo setPlayerName()
    private Inventar inventar;
    private Level playerLevel;
    private int playerGold;

    //Damit das legen in der zwischenzeit für andere Spieler auch funktioniert. Rundensystem ist noch nicht vollständig implementiert, Monster + Kampf fehlen
//    public static Boolean istDranAktiviert = true;

    public Player()
    {
        playerLevel = new Level();
        inventar = new Inventar();
        istDran = false;
        playerAusrüstung = new PlayerAusrüstung();
    }

    public Player(PlayerData playerData)
    {
        this.name = playerData.name;
        this.connectionId = playerData.connectionId;
        this.istDran = playerData.istDran;
        this.playerBoardNumber = playerData.playerBoardNumber;

        playerLevel = new Level();
        inventar = new Inventar();
        istDran = false;
        playerAusrüstung = new PlayerAusrüstung();
    }

    //Only call when Spielfeld is completely loaded
    public void initializeUIConnection()
    {
        getInventar().initializeUIConnection();
    }

    //---------Getter/Setter-----------
    public  static  Player getLocalPlayer()
    {
        return localPlayer;
    }

    //Bitte nur am Anfang des Spiels in der Main Activity setzen!!!!
    public static void setLocalPlayer(Player localPlayer) {
        Player.localPlayer = localPlayer;
    }

    public Inventar getInventar()
    {   return  inventar;   }


    public Level getPlayerLevel() {
        return playerLevel;
    }
    //-----------------------------------

    public PlayerAusrüstung getPlayerAusrüstung() {
        return playerAusrüstung;
    }

    public void addGold(int amount) {
        playerGold += amount;
        if(playerGold >= 1000 && playerLevel.getLevel() < 9) {
            playerLevel.levelIncrease();
            playerGold = 0;
        }
    }


    /**
     *Just for UI. Should turn the board, that the right player is in the right place. dont use this for logic
     * @return
     */
    public int getRelativePlayerBoardNumber()
    {
        return (playerBoardNumber - Player.getLocalPlayer().playerBoardNumber) % 4;
    }
}
