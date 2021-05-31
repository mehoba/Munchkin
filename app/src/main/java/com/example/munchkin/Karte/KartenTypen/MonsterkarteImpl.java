package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Player;

public class MonsterkarteImpl implements MonsterKarte {
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

    @Override
    public int getMonsterLevel() {
        return level;
    }

    @Override
    public void setMonsterLevel(int level) {
        this.level = level;
    }

    @Override
    public int getAnzahlSchätze() {
        return anzahlSchätze;
    }

    @Override
    public void setAnzahlSchätze(int anzahlSchätze) {
        this.anzahlSchätze=anzahlSchätze;
    }

    @Override
    public int getGewonneneLevel() {
        return gewonneneLevel;
    }

    @Override
    public void setGewonneneLevel(int gewonneneLevel) {
        this.gewonneneLevel=gewonneneLevel;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }


    //ÜBernommen von MonsterCardsImpl

    @Override
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

    @Override
    public void runAway() {
        //TODO
    }

    //setting category to know what kind of bad stuff will happen
    @Override
    public int getBadCategory() {
        return this.badCategory;
    }

    @Override
    public void setBadCategory(int badCategory) {
        this.badCategory=badCategory;
    }



    //Impl von Chibi
    @Override
    public void schlimmeDinge() {
        Player.getLocalPlayer().getPlayerLevel().levelDecrease();
    }
}
