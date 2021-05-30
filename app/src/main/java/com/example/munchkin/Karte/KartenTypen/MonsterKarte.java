package com.example.munchkin.Karte.KartenTypen;

public interface MonsterKarte extends Türkarte {

    int getLevel();
    void setLevel(int level);

    int getAnzahlSchätze();
    void setAnzahlSchätze(int anzahlSchätze);

    //Übernommen von MonsterCards
    void badStuff(int playerLevel, int badCategory, int levelMinus);
    void runAway();
    int getBadCategory();
    void setBadCategory(int badCategory);

}
