package com.example.munchkin.Karte;

public interface Karte {
      int getImage();
      void setImage(int image);
      void karteHeben();
      void karteAblegen();
      CardType getCardType();
}
