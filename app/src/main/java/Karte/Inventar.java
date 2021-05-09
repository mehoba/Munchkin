package Karte;

public class Inventar {

    public Inventar(){
        setKartenArray(this.KartenArray);
        setHandKarten(this.handKarten);
    }
    public Karte [] KartenArray;

    public Karte[] getKartenArray(){
        return KartenArray;
    }
    public void setKartenArray(Karte [] kartenArray){
        this.KartenArray=kartenArray;
    }

    public HandKarten getHandKarten() {
        return handKarten;
    }

    public void setHandKarten(HandKarten handKarten) {
        this.handKarten = handKarten;
    }

    private HandKarten handKarten;

}
