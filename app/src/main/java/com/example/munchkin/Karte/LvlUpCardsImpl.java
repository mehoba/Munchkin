package com.example.munchkin.Karte;

public class LvlUpCardsImpl implements LvlUpCards {
    private int image;
    private CardType cardType;
    private int Goldwert;

    public LvlUpCardsImpl(int image, CardType cardType){
        setImage(image);
        setCardType(cardType);
    }
    @Override
    public int increaceLvlByOnePermanet(int currentLevel) {
        currentLevel++;
        return currentLevel;
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
