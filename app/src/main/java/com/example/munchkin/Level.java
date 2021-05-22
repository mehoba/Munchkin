package com.example.munchkin;

import android.content.Intent;

public class Level {

    private int level = 9;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private void notifyAboutWin() {
        Intent i = new Intent(sourceActivity.getApplicationContext(),WinnerPopActivity.class);
        sourceActivity.startActivity(i);
    }
}
