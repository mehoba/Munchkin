package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public interface FluchKarte extends Türkarte {

    //Übernommen von FluchCards
    void loseArmor(BodyPart bodyPart, int size);
    void loseLevel(int lostLevels);
}
