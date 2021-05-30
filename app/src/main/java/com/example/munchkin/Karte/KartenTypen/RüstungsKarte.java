package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public interface RüstungsKarte extends Schatzkarte{
    //Übernommen aus RustungCards
    void addBonus(int currentLvl);

    BodyPart getBodyPart();
    void setBodyPart(BodyPart bodyPart);
    int getSizeOfBonus();
    void setSizeOfBonus(int sizeOfBonus);
    int getSizeOfArmor();
    void setSizeOfArmor(int sizeOfArmor);
}
