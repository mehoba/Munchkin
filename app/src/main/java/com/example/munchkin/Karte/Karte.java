package com.example.munchkin.Karte;

import java.util.Random;

public interface Karte {

      public int getImage();
      public void onKarteGehoben();
      public void onkarteAusgespielt();
      public CardType getCardType();
      public void setCardType(CardType cardType);

       static Karte getRandomKarte() {
             int count = Inventar.getKartenList().size() - 1;
             Random rand = new Random();
             int randomCardIndex = rand.nextInt(count);
             return Inventar.getKartenList().get(randomCardIndex);
       }
}