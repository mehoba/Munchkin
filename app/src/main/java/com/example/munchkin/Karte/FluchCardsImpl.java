package com.example.munchkin.Karte;

public class FluchCardsImpl  implements FluchCards{
    private int image, lostLevel;
    private CardType cardType;
    private BodyPart bodyPart;


    public FluchCardsImpl(int image, CardType cardType, int lostLevel, BodyPart bodyPart){
        setImage(image);
        setCardType(cardType);
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

    @Override
    public CardType getCardType() {
        return cardType;
    }

    @Override
    public void setCardType(CardType cardType) {
        this.cardType=cardType;
    }
}
