package com.example.munchkin.Karte.KartenTypen;


public class Buffkarte extends SchatzkarteImpl{
    private int goldwert;
    private int image;

    //Übernommen aus BuffCardsImpl
    private int battleDamage;
    private int monsterLvlup;

//    Konstruktor aus BuffCardsImpl
//    public BuffkarteImpl(int image, int battleDamage, int monsterLvlup){
//        setImage(image);
//        setBattleDamage(battleDamage);
//        setMonsterLvlup(monsterLvlup);
//    }

    //Übernommen aus BuffCardsImpl

    //Buff cards level up monster

    public void monsterLvlUp(int montsterLevel) {
        montsterLevel=monsterLvlup+montsterLevel;
    }

    //Buff cards make more damage in battle

    public void moreDamageAfterBattle(int battleDamage) {
        //TODO
    }

    public int getBattleDamage() {
        return battleDamage;
    }

    public void setBattleDamage(int battleDamage) {
        this.battleDamage = battleDamage;
    }

    public int getMonsterLvlup() {
        return monsterLvlup;
    }

    public void setMonsterLvlup(int monsterLvlup) {
        this.monsterLvlup = monsterLvlup;
    }
}
