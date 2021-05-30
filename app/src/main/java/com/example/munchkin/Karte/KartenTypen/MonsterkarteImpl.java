package com.example.munchkin.Karte.KartenTypen;

public class MonsterkarteImpl implements MonsterKarte {
    int stufe;
    int anzahlSchätze;
    int image;

    @Override
    public int getStufe() {
        return stufe;
    }

    @Override
    public void setStufe(int stufe) {
        this.stufe = stufe;
    }

    @Override
    public int getImage() {
        return image;
    }

    @Override
    public void setImage(int image) {
        this.image = image;
    }
}
