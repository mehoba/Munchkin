package Karte;

public class HandKarten extends Inventar {

  
    public boolean checkIfMoreThan7(){

        if(getKartenArray().length>7)
            return true;
        else return false;
    }
}
