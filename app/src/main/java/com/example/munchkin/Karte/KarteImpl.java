package com.example.munchkin.Karte;


import java.util.Random;

public class KarteImpl implements Karte {

   // private CardType cardType;
    public int image;

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

    //@Override
    //public CardType getCardType() {
       // return this.cardType;
    //}

    public static Karte getRandomKarte()
    {
        int count = Inventar.getKartenList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getKartenList().get(randomCardIndex);
    }
}
