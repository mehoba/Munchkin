package com.example.munchkin.Karte;

public interface MonsterCards  extends Karte{

     int getLevel();
     void setLevel(int level);
     void badStuff(int playerLevel, int badCategory, int levelMinus);
     void runAway();
     int getBadCategory();
     void setBadCategory(int badCategory);


}
