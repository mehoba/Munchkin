package com.example.munchkin;

import android.content.Intent;

public class Level {

    public int level = 1;

    private SpielfeldActivity sourceActivity;

    public Level(SpielfeldActivity sourceActivity) {
        this.sourceActivity = sourceActivity;
    }

    void levelIncrease(){
        level++;

        if(level == 10){
            Intent i=new Intent(sourceActivity.getApplicationContext(),WinnerPopActivity.class);
            sourceActivity.startActivity(i);
        }
    }

    void levelDecrease(){
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
