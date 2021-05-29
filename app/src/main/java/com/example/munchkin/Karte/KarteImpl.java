package com.example.munchkin.Karte;


public class KarteImpl implements Karte {

    private CardType cardType;
    public int image;

    public KarteImpl(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    private String beschreibung;

    @Override
    public CardType getCardType() {
        return this.cardType;
    }

    @Override
    public void setCardType(CardType cardType) {
        this.cardType=cardType;
    }
}
