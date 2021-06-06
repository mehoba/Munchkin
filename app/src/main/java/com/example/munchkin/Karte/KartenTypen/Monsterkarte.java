package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Player;

public class Monsterkarte extends TürkarteImpl {
    private int monsterLevel;
    private int anzahlSchätze;
    private int gewonneneLevel;

//    Konstruktor aus MonstercardsImpl
    public Monsterkarte(int image, int monsterLevel, int anzahlSchätze){
        super(image);

        this.monsterLevel=monsterLevel;
        this.gewonneneLevel = 1;                //ist standardmäßig 1 auser es wird überschrieben mit setGewonneneLevel
        this.anzahlSchätze=anzahlSchätze;

    }

    public Monsterkarte(int image, int monsterLevel, int anzahlSchätze, int gewonneneLevel){
        super(image);

        this.monsterLevel=monsterLevel;
        this.gewonneneLevel = gewonneneLevel;
        this.anzahlSchätze=anzahlSchätze;

    }

    public int getMonsterLevel() {
        return monsterLevel;
    }

    public int getAnzahlSchätze() {
        return anzahlSchätze;
    }

    public int getGewonneneLevel() {
        return gewonneneLevel;
    }

    //Impl von Chibi

    public void schlimmeDinge() {
        Player.getLocalPlayer().getPlayerLevel().levelDecrease();
    }





    //Übernommen von MonsterCardsImpl
    private  int badCategory;

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

    //setting category to know what kind of bad stuff will happen

    public int getBadCategory() {
        return this.badCategory;
    }

    public void setBadCategory(int badCategory) {
        this.badCategory=badCategory;
    }




}
