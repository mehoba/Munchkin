package com.example.munchkin.Karte;

import com.example.munchkin.R;

import java.util.ArrayList;
import java.util.List;

public class Inventar {




    public List<Karte> getKartenList() {
        return KartenList;
    }

    public void setKartenList() {
        KartenList=new ArrayList<>();
        KarteImpl k1 = new KarteImpl();
        k1.setImage(R.drawable.cards1);
        KarteImpl k2= new KarteImpl();
        k2.setImage(R.drawable.cards2);
        KartenList.add(k1);
        KartenList.add(k2);
        KarteImpl k3=new KarteImpl();
        k3.setImage(R.drawable.cards3);;
        KartenList.add(k3);
        KarteImpl k4= new KarteImpl();
        k4.setImage(R.drawable.cards4);
        KartenList.add(k4);
        KarteImpl k5= new KarteImpl();
        k5.setImage(R.drawable.cards5);
        KartenList.add(k5);
        KarteImpl k6 = new KarteImpl();
        k6.setImage(R.drawable.cards6);
        KartenList.add(k6);
        KarteImpl k7 = new KarteImpl();
        k7.setImage(R.drawable.cards7);
        KartenList.add(k7);
        KarteImpl k8= new KarteImpl();
        k8.setImage(R.drawable.cards8);
        KartenList.add(k8);
        KarteImpl k9 = new KarteImpl();
        k9.setImage(R.drawable.cards9);
        KartenList.add(k9);
        KarteImpl k10= new KarteImpl();
        k10.setImage(R.drawable.cards10);
        KartenList.add(k10);

    }

    public ArrayList<Karte> KartenList;

}
