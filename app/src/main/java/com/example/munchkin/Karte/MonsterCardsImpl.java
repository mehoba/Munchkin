package com.example.munchkin.Karte;

import android.content.Intent;

import com.example.munchkin.CardPopActivity;
import com.example.munchkin.DiceActivity;

import static androidx.core.content.ContextCompat.startActivity;

public class MonsterCardsImpl  implements MonsterCards{
    private int level, image, badCategory;


    public MonsterCardsImpl(int level, int image,int badCategory){
        setBadCategory(badCategory);
        setImage(image);
        setLevel(level);
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public void setLevel(int level) {
        this.level=level;
    }

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

    //getting setting image view for each card
    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
this.image=image;
    }
}
