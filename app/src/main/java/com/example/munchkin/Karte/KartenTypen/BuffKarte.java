package com.example.munchkin.Karte.KartenTypen;

public interface BuffKarte extends Schatzkarte{

    //Übernommen aus BuffCards
    void monsterLvlUp(int montsterLevel);
    void moreDamageAfterBattle(int battleDamage);

    public int getBattleDamage();
    public void setBattleDamage(int battleDamage);
    public int getMonsterLvlup();
    public void setMonsterLvlup(int monsterLvlup);

}
