package com.example.munchkin;

import android.content.Intent;

public class Level {

    public int level = 1;

    void levelIncrease(){
        level++;

        if(level == 10){
            //ToDo: Person has won the game - popup Help

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
