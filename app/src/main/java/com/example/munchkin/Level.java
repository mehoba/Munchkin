package com.example.munchkin;

import android.util.Log;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Networking.GameClient;

public class Level {

    private int level;
    private Player player;

    public Level(){
        level = 1;
    }

    public void levelIncrease(){
        level++;
        Log.i("lvl empfangen für: " + player.name, Integer.toString(level));

        checkIfWon();

        GameClient.sendPlayerLevel(player);
        Log.i("lvl", "SendPlayerLvlIncrease from lvl Player: " + player.name);
    }

    public void levelDecrease(){
        if (level !=1){
            level --;
            GameClient.sendPlayerLevel(player);
        }
    }

    void checkIfWon()
    {
        if(level >= 10){
            if(SpielfeldActivity.getInstance() != null){
                SpielfeldActivity.getInstance().notifyAboutWin();
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        checkIfWon();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
