package com.example.munchkin;

import android.content.Intent;

public class Level {

    private int level = 1;
    private SpielfeldActivity sourceActivity;

    public Level(SpielfeldActivity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

    void levelIncrease(){
        level++;

        if(level == 10){
            notifyAboutWin();
        }
    }

    void levelDecrease(){
        if (level !=1){
            level --;
        }
    }

    int getLevel(){
        return level;
    }

    private void notifyAboutWin() {

        Intent i=new Intent(sourceActivity.getApplicationContext(),WinPopActivity.class);
        sourceActivity.startActivity(i);
    }
}
