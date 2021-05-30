package com.example.munchkin.Karte;

public class BuffCardsImpl implements BuffCards {
    private int image;

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

    private int battleDamage;
    private int monsterLvlup;
    private CardType cardType;

    public BuffCardsImpl(int image, CardType cardType, int battleDamage, int monsterLvlup){
        setImage(image);
        setCardType(cardType);
        setBattleDamage(battleDamage);
        setMonsterLvlup(monsterLvlup);
    }
    //Buff cards level up monster
    @Override
    public void monsterLvlUp(int montsterLevel) {
        montsterLevel=monsterLvlup+montsterLevel;
    }

    //Buff cards make more damage in battle
    @Override
    public void moreDamageAfterBattle(int battleDamage) {
        //TODO
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
this.image=image;
    }

    @Override
    public CardType getCardType() {
        return this.cardType;
    }

    @Override
    public void setCardType(CardType cardType) {
        this.cardType=cardType;
    }
}
