package com.example.munchkin.Karte.KartenTypen;

public interface MonsterKarte extends Türkarte {

    int getMonsterLevel();
    void setMonsterLevel(int level);

    int getAnzahlSchätze();
    void setAnzahlSchätze(int anzahlSchätze);

    int getGewonneneLevel();
    void setGewonneneLevel(int gewonneneLevel);

    //Übernommen von MonsterCards
    void badStuff(int playerLevel, int badCategory, int levelMinus);
    void runAway();
    int getBadCategory();
    void setBadCategory(int badCategory);

    void schlimmeDinge();

}
