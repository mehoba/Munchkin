package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Player;

public class Monsterkarte extends TürkarteImpl {
    private int level;
    private int anzahlSchätze;
    private int gewonneneLevel = 1; //ist standardmäßig 1 auser es wird überschrieben mit setGewonneneLevel
    private int image;

    //Übernommen von MonsterCardsImpl
    private  int badCategory;

//    Konstruktor aus MonstercardsImpl
//    public MonsterkarteImpl(int level, int image,int badCategory){
//        setBadCategory(badCategory);
//        setImage(image);
//        setLevel(level);
//    }


    public int getMonsterLevel() {
        return level;
    }


    public void setMonsterLevel(int level) {
        this.level = level;
    }

    public int getAnzahlSchätze() {
        return anzahlSchätze;
    }


    public void setAnzahlSchätze(int anzahlSchätze) {
        this.anzahlSchätze=anzahlSchätze;
    }


    public int getGewonneneLevel() {
        return gewonneneLevel;
    }


    public void setGewonneneLevel(int gewonneneLevel) {
        this.gewonneneLevel=gewonneneLevel;
    }



    //ÜBernommen von MonsterCardsImpl


    public void badStuff(int playerLevel, int badCategorym, int levelMinus) {
        badCategory=getBadCategory();
        switch (badCategory){
            //in case of 0 then it is card where there is no bad stuff
            case 1:
                playerLevel= playerLevel-levelMinus; //Level Decrease
                break;
            case 2:
                playerLevel=0; //Dead
                break;
            case 3:
                //TODO money decrease
                break;

        }
    }


    public void runAway() {
        //TODO
    }

    //setting category to know what kind of bad stuff will happen

    public int getBadCategory() {
        return this.badCategory;
    }


    public void setBadCategory(int badCategory) {
        this.badCategory=badCategory;
    }



    //Impl von Chibi

    public void schlimmeDinge() {
        Player.getLocalPlayer().getPlayerLevel().levelDecrease();
    }
}
