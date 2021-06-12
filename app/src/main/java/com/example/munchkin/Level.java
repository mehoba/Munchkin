package com.example.munchkin;

import android.content.Intent;
import android.util.Log;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Activity.WinnerPopActivity;
public class Level {

    private int level;
    private Player player;

    public Level(){
        level = 1;
    }

    public void levelIncrease(){
        level++;
        Log.i("Lvl", Integer.toString(level));
        if(level >= 10){
            if(SpielfeldActivity.getInstance() != null){
                SpielfeldActivity.getInstance().notifyAboutWin();
            }
        }
    }

    public void levelDecrease(){
        if (level !=1){
            level --;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
