package com.example.munchkin.Karte;

import java.util.List;

public class HandKarten extends Inventar {


    public List<Karte> getHandKarten() {
        return handKarten;
    }

    public void setHandKarten(List<Karte> handKarten) {
        this.handKarten = handKarten;
    }

    private List<Karte> handKarten;

    public boolean checkIfMoreThan7(){

        if(getHandKarten().size() >7)
            return true;
        else return false;
    }
}
