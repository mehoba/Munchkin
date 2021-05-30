package com.example.munchkin.Karte;

public class FluchCardsImpl  implements FluchCards{
    private int image, lostLevel;
    private BodyPart bodyPart;


    public FluchCardsImpl(int image, int lostLevel, BodyPart bodyPart){
        setImage(image);
        this.lostLevel=lostLevel;
        this.bodyPart=bodyPart;

    }
    @Override
    public void loseArmor(BodyPart bodyPart, int size) {

    }

    @Override
    public void loseLevel(int currentLvl) {
        currentLvl-= lostLevel;
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
