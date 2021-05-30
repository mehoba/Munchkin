package com.example.munchkin.Karte;

public class RustungCardsImpl implements  RustungCards{


    private BodyPart bodyPart;
    private int sizeOfBonus, sizeOfArmor, image;

    public RustungCardsImpl(int image, int sizeOfArmor, int sizeOfBonus, BodyPart bodyPart){
        setBodyPart(bodyPart);
        setImage(image);
        setSizeOfArmor(sizeOfArmor);
        setSizeOfBonus(sizeOfBonus);
    }

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

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image=image;
    }
}
