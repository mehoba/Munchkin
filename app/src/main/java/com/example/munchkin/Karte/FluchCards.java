package com.example.munchkin.Karte;

public interface FluchCards  extends Karte{
    void loseArmor(BodyPart bodyPart, int size);
     void loseLevel(int lostLevels);

}
