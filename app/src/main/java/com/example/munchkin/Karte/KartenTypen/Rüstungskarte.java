package com.example.munchkin.Karte.KartenTypen;

import com.example.munchkin.Karte.BodyPart;

public class Rüstungskarte extends SchatzkarteImpl{
    //Please DONT use this Konstruktor - it is needed for Networking
    public Rüstungskarte(){}

    //Variablen
    private BodyPart bodyPart;
    private int sizeOfBonus;
    private int sizeOfArmor;
    private boolean isGroß;

    //Konstruktor aus RustungCardsImpl
    public Rüstungskarte(int image, int goldwert, int sizeOfArmor, int sizeOfBonus, BodyPart bodyPart){
        super(image, goldwert);

        //Statt set wird nun direkt in Konstruktor gesetzt, da nachträglich nicht veränderbar sein sollte
        this.bodyPart = bodyPart;
        this.sizeOfBonus = sizeOfBonus; //The size of bonus card applies
        this.sizeOfArmor = sizeOfArmor;

        this.isGroß=false;  //Standartmäßig sind gegenstände klein
    }

    public Rüstungskarte(int image, int goldwert, int sizeOfArmor, int sizeOfBonus, BodyPart bodyPart, boolean isGroß){
        super(image, goldwert);

        //Statt set wird nun direkt in Konstruktor gesetzt, da nachträglich nicht veränderbar sein sollte
        this.bodyPart = bodyPart;
        this.sizeOfBonus = sizeOfBonus; //The size of bonus card applies
        this.sizeOfArmor = sizeOfArmor;

        this.isGroß=isGroß;  //Größe der Rüstung wird gesetzt
    }


    //Methoden - Übernommen aus RustungCardsImpl

    //To which Body part it will applied(HAND,FOOT,BODY or HEAD)
    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public int getSizeOfBonus() {
        return sizeOfBonus;
    }

    //Size of Armor, e.g. 2 Hands
    public int getSizeOfArmor() {
        return sizeOfArmor;
    }

    //Um zu ermitteln ob dies ein großes Rüstungsteil ist
    public boolean getIsGroß(){
        return isGroß;
    }

}
