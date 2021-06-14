package com.example.munchkin;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.KartenTypen.RassenKarte;

public class Player extends PlayerData
{
    private static Player localPlayer;

    private PlayerAusrüstung playerAusrüstung;
    private Inventar inventar;
    private Level playerLevel;
    private int playerGold;
    private PlayerSideUI playerSideUI;
    private Rasse rasse;

    public Player()
    {
        playerLevel = new Level();
        inventar = new Inventar();
        istDran = false;
        playerAusrüstung = new PlayerAusrüstung();
        rasse = Rasse.NONE;
    }

    public Player(PlayerData playerData)
    {
        this.name = playerData.name;
        this.connectionId = playerData.connectionId;
        this.istDran = playerData.istDran;
        this.playerBoardNumber = playerData.playerBoardNumber;

        playerLevel = new Level();
        playerLevel.setPlayer(this);
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

    public Rasse getRasse() {
        return this.rasse;
    }

    public void onRassenkarte(RassenKarte karte) {
        this.rasse = karte.getRasse();
        this.playerSideUI.getImgPlayerRasse().setImageResource(karte.getImage());
    }

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
        return  Math.floorMod(playerBoardNumber - Player.getLocalPlayer().playerBoardNumber, 4);
    }

    public PlayerSideUI getPlayerSideUI() {
        return playerSideUI;
    }


    /**
     * Only call when UI finished loading
     */
    public void setPlayerSideUI()
    {
        this.playerSideUI = PlayerSideUI.getPlayerSideUI(getRelativePlayerBoardNumber());
        this.playerSideUI.showAll();
        this.playerSideUI.initializeUI(this );
    }

    public boolean isLocal() {
        return Player.getLocalPlayer().playerBoardNumber == playerBoardNumber;
    }
}
