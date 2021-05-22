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

        //Adding Buff Cards
        k1.setImage(R.drawable.buffcard1);
        KarteImpl k2= new KarteImpl();
        k2.setImage(R.drawable.buffcard2);
        KartenList.add(k1);
        KartenList.add(k2);
        KarteImpl k3=new KarteImpl();
        k3.setImage(R.drawable.buffcard3);
        KartenList.add(k3);
        KarteImpl k4= new KarteImpl();
        k4.setImage(R.drawable.buffcard4);
        KartenList.add(k4);
        KarteImpl k5= new KarteImpl();
        k5.setImage(R.drawable.buffcard5);
        KartenList.add(k5);
        KarteImpl k6 = new KarteImpl();
        k6.setImage(R.drawable.buffcard6);
        KartenList.add(k6);

        //Adding level up cards
        KarteImpl k7 = new KarteImpl();
        k7.setImage(R.drawable.lvlupcard1);
        KartenList.add(k7);
        KarteImpl k8= new KarteImpl();
        k8.setImage(R.drawable.lvlupcard2);
        KartenList.add(k8);
        KarteImpl k9 = new KarteImpl();
        k9.setImage(R.drawable.lvlupcard3);
        KartenList.add(k9);
        KarteImpl k10= new KarteImpl();
        k10.setImage(R.drawable.lvlupcard4);
        KartenList.add(k10);

        //Adding rustungs cards
        KarteImpl k11= new KarteImpl();
        k11.setImage(R.drawable.rustungcard1);
        KartenList.add(k11);
        KarteImpl k12= new KarteImpl();
        k12.setImage(R.drawable.rustungcard2);
        KartenList.add(k12);
        KarteImpl k13= new KarteImpl();
        k13.setImage(R.drawable.rustungcard3);
        KartenList.add(k13);
        KarteImpl k14= new KarteImpl();
        k14.setImage(R.drawable.rustungcard4);
        KartenList.add(k14);
        KarteImpl k15= new KarteImpl();
        k15.setImage(R.drawable.rustungcard5);
        KartenList.add(k15);
        KarteImpl k16= new KarteImpl();
        k16.setImage(R.drawable.rustungcard6);
        KartenList.add(k16);
        KarteImpl k17= new KarteImpl();
        k17.setImage(R.drawable.rustungcard7);
        KartenList.add(k17);
        KarteImpl k18= new KarteImpl();
        k18.setImage(R.drawable.rustungcard8);
        KartenList.add(k18);
        KarteImpl k19= new KarteImpl();
        k19.setImage(R.drawable.rustungcard9);
        KartenList.add(k19);
        KarteImpl k20= new KarteImpl();
        k20.setImage(R.drawable.rustungcard10);
        KartenList.add(k20);
        KarteImpl k21= new KarteImpl();
        k21.setImage(R.drawable.rustungcard11);
        KartenList.add(k21);
        KarteImpl k22= new KarteImpl();
        k22.setImage(R.drawable.rustungcard12);
        KartenList.add(k22);
        KarteImpl k23= new KarteImpl();
        k23.setImage(R.drawable.rustungcard13);
        KartenList.add(k23);
        KarteImpl k24= new KarteImpl();
        k24.setImage(R.drawable.rustungcard14);
        KartenList.add(k24);

        //Adding fluch cards
        KarteImpl k25= new KarteImpl();
        k25.setImage(R.drawable.fluchcard1);
        KartenList.add(k25);
        KarteImpl k26= new KarteImpl();
        k26.setImage(R.drawable.fluchcard2);
        KartenList.add(k26);
        KarteImpl k27= new KarteImpl();
        k27.setImage(R.drawable.fluchcard3);
        KartenList.add(k27);
        KarteImpl k28= new KarteImpl();
        k28.setImage(R.drawable.fluchcard4);
        KartenList.add(k28);

        //Adding Klassen cards
        KarteImpl k29= new KarteImpl();
        k29.setImage(R.drawable.klasscard1);
        KartenList.add(k29);
        KarteImpl k30= new KarteImpl();
        k30.setImage(R.drawable.klasscard2);
        KartenList.add(k30);
        KarteImpl k31= new KarteImpl();
        k31.setImage(R.drawable.klasscard3);
        KartenList.add(k31);
        KarteImpl k32= new KarteImpl();
        k32.setImage(R.drawable.klasscard4);
        KartenList.add(k32);

        //Adding monster cards
        KarteImpl k33= new KarteImpl();
        k33.setImage(R.drawable.monstercard1);
        KartenList.add(k33);
        KarteImpl k34= new KarteImpl();
        k34.setImage(R.drawable.monstercard2);
        KartenList.add(k34);
        KarteImpl k35= new KarteImpl();
        k35.setImage(R.drawable.monstercard3);
        KartenList.add(k35);
        KarteImpl k36= new KarteImpl();
        k36.setImage(R.drawable.monstercard4);
        KartenList.add(k36);
        KarteImpl k37= new KarteImpl();
        k37.setImage(R.drawable.monstercard5);
        KartenList.add(k37);
        KarteImpl k38= new KarteImpl();
        k38.setImage(R.drawable.monstercard6);
        KartenList.add(k38);
        KarteImpl k39= new KarteImpl();
        k39.setImage(R.drawable.monstercard7);
        KartenList.add(k39);
        KarteImpl k40= new KarteImpl();
        k40.setImage(R.drawable.monstercard8);
        KartenList.add(k40);
        KarteImpl k41= new KarteImpl();
        k41.setImage(R.drawable.monstercard9);
        KartenList.add(k41);
        KarteImpl k42= new KarteImpl();
        k42.setImage(R.drawable.monstercard9);
        KartenList.add(k42);
        KarteImpl k43= new KarteImpl();
        k43.setImage(R.drawable.monstercard10);
        KartenList.add(k43);
        KarteImpl k44= new KarteImpl();
        k44.setImage(R.drawable.monstercard11);
        KartenList.add(k44);
        KarteImpl k45= new KarteImpl();
        k45.setImage(R.drawable.monstercard12);
        KartenList.add(k45);
        KarteImpl k46= new KarteImpl();
        k46.setImage(R.drawable.monstercard13);
        KartenList.add(k46);
        KarteImpl k47= new KarteImpl();
        k47.setImage(R.drawable.monstercard14);
        KartenList.add(k47);

        //Adding Rassen cards
        KarteImpl k48= new KarteImpl();
        k48.setImage(R.drawable.rassencard1);
        KartenList.add(k48);
        KarteImpl k49= new KarteImpl();
        k49.setImage(R.drawable.rassencard2);
        KartenList.add(k49);
        KarteImpl k50= new KarteImpl();
        k50.setImage(R.drawable.rassencard3);
        KartenList.add(k50);

    }

    public ArrayList<Karte> KartenList;

}
