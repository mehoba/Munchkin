package com.example.munchkin.Karte;


public class KarteImpl implements Karte {

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }

    public int image;
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    private String beschreibung;

    @Override
    public void karteHeben() {
        //TODO
    }

    @Override
    public void karteAblegen() {
        //TODO
    }
}
