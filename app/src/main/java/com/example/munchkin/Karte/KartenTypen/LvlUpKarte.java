package com.example.munchkin.Karte.KartenTypen;


import com.example.munchkin.Karte.CardType;
import com.example.munchkin.Player;

public class LvlUpKarte extends SchatzkarteImpl {
    //Please DONT use this Konstruktor - it is needed for Networking
    public LvlUpKarte(){}

    private CardType cardType;

    @Override
    public void setCardType(CardType cardType) {
        this.cardType= cardType;
    }

    @Override
    public CardType getCardType() {
        return  cardType;
    }

    //Konstruktor
    public LvlUpKarte(int image) {
        super(image, 0);    //Konstruktor von SchatzkarteImpl aufrufen
                                    // Goldwert muss 0 sein
        setCardType(CardType.LVLUPKARTE);
    }

    //Methoden
    public void triggerPlayerLvlIncrease(){
        Player.getLocalPlayer().getPlayerLevel().levelIncrease();
    }

}
