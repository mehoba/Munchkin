package com.example.munchkin.Karte;

import java.util.Random;

public interface Karte {

      int getImage();
      void setImage(int image);

       static Karte getRandomKarte() {
             int count = Inventar.getKartenList().size() - 1;
             Random rand = new Random();
             int randomCardIndex = rand.nextInt(count);
             return Inventar.getKartenList().get(randomCardIndex);
       }
}
