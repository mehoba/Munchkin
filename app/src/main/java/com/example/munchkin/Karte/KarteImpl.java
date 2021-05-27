package com.example.munchkin.Karte;


import java.util.Random;

public class KarteImpl implements Karte {

   // private CardType cardType;
    public int image;
    private String beschreibung;
    private String name;

    public static Karte getRandomKarte()
    {
        int count = Inventar.getKartenList().size() - 1;
        Random rand = new Random();
        int randomCardIndex = rand.nextInt(count);
        return Inventar.getKartenList().get(randomCardIndex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
