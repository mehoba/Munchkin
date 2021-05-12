package com.example.munchkin;

public class Level {

    private int level = 1;

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

    int getLevel(){
        return level;
    }


}
