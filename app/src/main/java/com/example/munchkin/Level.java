package com.example.munchkin;

import android.content.Intent;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Activity.WinnerPopActivity;

public class Level {

    private int level;

    public Level(){
        level = 1;
    }

    public void levelIncrease(){
        level++;
        if(level >= 10){
            SpielfeldActivity.getInstance().notifyAboutWin();;
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

}
