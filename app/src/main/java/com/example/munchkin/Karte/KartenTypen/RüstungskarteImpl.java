package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class RüstungskarteImpl implements RüstungsKarte
{

    private int goldwert;
    private int image;

    //Übernommen aus RustungCardsImpl
    private BodyPart bodyPart;
    private int sizeOfBonus, sizeOfArmor;

//    Konstruktor aus RustungCardsImpl
//    public RüstungskarteImpl(int image, int sizeOfArmor, int sizeOfBonus, BodyPart bodyPart){
//        setBodyPart(bodyPart);
//        setImage(image);
//        setSizeOfArmor(sizeOfArmor);
//        setSizeOfBonus(sizeOfBonus);
//    }

    @Override
    public int getGoldwert() {
        return goldwert;
    }

    @Override
    public void SetGoldwert(int goldwert) {
        this.goldwert=goldwert;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }

    //Übernommen aus RustungCardsImpl

    //To which Body part it will applied(HAND,FOOT,BODY or HEAD)
    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public int getSizeOfBonus() {
        return sizeOfBonus;
    }

    //The size of bonus card applies
    public void setSizeOfBonus(int sizeOfBonus) {
        this.sizeOfBonus = sizeOfBonus;
    }

    //Size of Armor, e.g. 2 Hands
    public int getSizeOfArmor() {
        return sizeOfArmor;
    }

    public void setSizeOfArmor(int sizeOfArmor) {
        this.sizeOfArmor = sizeOfArmor;
    }

    @Override
    public void addBonus(int currentLvl) {
        currentLvl+=sizeOfArmor;
    }


}
