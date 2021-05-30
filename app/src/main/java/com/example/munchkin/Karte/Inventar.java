package com.example.munchkin.Karte;

import com.example.munchkin.Karte.KartenTypen.BuffkarteImpl;
import com.example.munchkin.Karte.KartenTypen.FluchkarteImpl;
import com.example.munchkin.Karte.KartenTypen.KlassenKarteImpl;
import com.example.munchkin.Karte.KartenTypen.LvlUpKarteImpl;
import com.example.munchkin.Karte.KartenTypen.MonsterkarteImpl;
import com.example.munchkin.Karte.KartenTypen.RassenKarteImpl;
import com.example.munchkin.Karte.KartenTypen.RüstungskarteImpl;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Karte.KartenTypen.Türkarte;
import com.example.munchkin.PlayerAusrüstung;
import com.example.munchkin.R;
import com.example.munchkin.SpielfeldActivity;

import java.util.ArrayList;
import java.util.List;

public class Inventar
{
    private final HandKarten handKarten;
    private final PlayerAusrüstung playerAusrüstung;
    private final KartenSlot klassenKarteSlot;
    private final KartenSlot rassenKarteSlot;

    public static ArrayList<Karte> KartenList;
    public static ArrayList<Schatzkarte> schatzkartenList;
    public static ArrayList<Türkarte> türKartenList;

    public Inventar()
    {
        initializeKartenList();

        handKarten = new HandKarten();
        playerAusrüstung = new PlayerAusrüstung();
        klassenKarteSlot = new KartenSlot(null);
        rassenKarteSlot = new KartenSlot(null);
    }

    public void initializeUIConnection()
    {
        SpielfeldActivity spielfeldActivity = SpielfeldActivity.getInstance();

        handKarten.initializeUIConnection();
        klassenKarteSlot.setImgKarte(spielfeldActivity.imgKlasse1);
        rassenKarteSlot.setImgKarte(spielfeldActivity.imgRasse1);
    }

    public static List<Karte> getKartenList() {
        return KartenList;
    }
    public static List<Schatzkarte> getSchatzkartenList() {
        return schatzkartenList;
    }
    public static List<Türkarte> getTürKartenList() {
        return türKartenList;
    }

    //ToDo Türkarten fehlen
    public static void initializeKartenList() {
        KartenList=new ArrayList<>();
        schatzkartenList = new ArrayList<>();
        türKartenList = new ArrayList<>();

        Karte k1 = new BuffkarteImpl();

        //Adding Buff Cards
        k1.setImage(R.drawable.buffcard1);
        Karte k2= new BuffkarteImpl();
        k2.setImage(R.drawable.buffcard2);
        addCardToKartenList(k1);
        addCardToKartenList(k2);
        Karte k3=new BuffkarteImpl();
        k3.setImage(R.drawable.buffcard3);
        addCardToKartenList(k3);
        Karte k4= new BuffkarteImpl();
        k4.setImage(R.drawable.buffcard4);
        addCardToKartenList(k4);
        Karte k5= new BuffkarteImpl();
        k5.setImage(R.drawable.buffcard5);
        addCardToKartenList(k5);
        Karte k6 = new BuffkarteImpl();
        k6.setImage(R.drawable.buffcard6);
        addCardToKartenList(k6);

        //Adding level up cards
        Karte k7 = new LvlUpKarteImpl();
        k7.setImage(R.drawable.lvlupcard1);
        addCardToKartenList(k7);
        Karte k8= new LvlUpKarteImpl();
        k8.setImage(R.drawable.lvlupcard2);
        addCardToKartenList(k8);
        Karte k9 = new LvlUpKarteImpl();
        k9.setImage(R.drawable.lvlupcard3);
        addCardToKartenList(k9);
        Karte k10= new LvlUpKarteImpl();
        k10.setImage(R.drawable.lvlupcard4);
        addCardToKartenList(k10);

        //Adding rustungs cards
        Karte k11= new RüstungskarteImpl();
        k11.setImage(R.drawable.rustungcard1);
        addCardToKartenList(k11);
        Karte k12= new RüstungskarteImpl();
        k12.setImage(R.drawable.rustungcard2);
        addCardToKartenList(k12);
        Karte k13= new RüstungskarteImpl();
        k13.setImage(R.drawable.rustungcard3);
        addCardToKartenList(k13);
        Karte k14= new RüstungskarteImpl();
        k14.setImage(R.drawable.rustungcard4);
        addCardToKartenList(k14);
        Karte k15= new RüstungskarteImpl();
        k15.setImage(R.drawable.rustungcard5);
        addCardToKartenList(k15);
        Karte k16= new RüstungskarteImpl();
        k16.setImage(R.drawable.rustungcard6);
        addCardToKartenList(k16);
        Karte k17= new RüstungskarteImpl();
        k17.setImage(R.drawable.rustungcard7);
        addCardToKartenList(k17);
        Karte k18= new RüstungskarteImpl();
        k18.setImage(R.drawable.rustungcard8);
        addCardToKartenList(k18);
        Karte k19= new RüstungskarteImpl();
        k19.setImage(R.drawable.rustungcard9);
        addCardToKartenList(k19);
        Karte k20= new RüstungskarteImpl();
        k20.setImage(R.drawable.rustungcard10);
        addCardToKartenList(k20);
        Karte k21= new RüstungskarteImpl();
        k21.setImage(R.drawable.rustungcard11);
        addCardToKartenList(k21);
        Karte k22= new RüstungskarteImpl();
        k22.setImage(R.drawable.rustungcard12);
        addCardToKartenList(k22);
        Karte k23= new RüstungskarteImpl();
        k23.setImage(R.drawable.rustungcard13);
        addCardToKartenList(k23);
        Karte k24= new RüstungskarteImpl();
        k24.setImage(R.drawable.rustungcard14);
        addCardToKartenList(k24);

        //Adding fluch cards
        Karte k25= new FluchkarteImpl();
        k25.setImage(R.drawable.fluchcard1);
        addCardToKartenList(k25);
        Karte k26= new FluchkarteImpl();
        k26.setImage(R.drawable.fluchcard2);
        addCardToKartenList(k26);
        Karte k27= new FluchkarteImpl();
        k27.setImage(R.drawable.fluchcard3);
        addCardToKartenList(k27);
        Karte k28= new FluchkarteImpl();
        k28.setImage(R.drawable.fluchcard4);
        addCardToKartenList(k28);

        //Adding Klassen cards
        Karte k29= new KlassenKarteImpl();
        k29.setImage(R.drawable.klasscard1);
        addCardToKartenList(k29);
        Karte k30= new KlassenKarteImpl();
        k30.setImage(R.drawable.klasscard2);
        addCardToKartenList(k30);
        Karte k31= new KlassenKarteImpl();
        k31.setImage(R.drawable.klasscard3);
        addCardToKartenList(k31);
        Karte k32= new KlassenKarteImpl();
        k32.setImage(R.drawable.klasscard4);
        addCardToKartenList(k32);

        //Adding monster cards
        Karte k33= new MonsterkarteImpl();
        k33.setImage(R.drawable.monstercard1);
        addCardToKartenList(k33);
        Karte k34= new MonsterkarteImpl();
        k34.setImage(R.drawable.monstercard2);
        addCardToKartenList(k34);
        Karte k35= new MonsterkarteImpl();
        k35.setImage(R.drawable.monstercard3);
        addCardToKartenList(k35);
        Karte k36= new MonsterkarteImpl();
        k36.setImage(R.drawable.monstercard4);
        addCardToKartenList(k36);
        Karte k37= new MonsterkarteImpl();
        k37.setImage(R.drawable.monstercard5);
        addCardToKartenList(k37);
        Karte k38= new MonsterkarteImpl();
        k38.setImage(R.drawable.monstercard6);
        addCardToKartenList(k38);
        Karte k39= new MonsterkarteImpl();
        k39.setImage(R.drawable.monstercard7);
        addCardToKartenList(k39);
        Karte k40= new MonsterkarteImpl();
        k40.setImage(R.drawable.monstercard8);
        addCardToKartenList(k40);
        Karte k41= new MonsterkarteImpl();
        k41.setImage(R.drawable.monstercard9);
        addCardToKartenList(k41);
        Karte k42= new MonsterkarteImpl();
        k42.setImage(R.drawable.monstercard9);
        addCardToKartenList(k42);
        Karte k43= new MonsterkarteImpl();
        k43.setImage(R.drawable.monstercard10);
        addCardToKartenList(k43);
        Karte k44= new MonsterkarteImpl();
        k44.setImage(R.drawable.monstercard11);
        addCardToKartenList(k44);
        Karte k45= new MonsterkarteImpl();
        k45.setImage(R.drawable.monstercard12);
        addCardToKartenList(k45);
        Karte k46= new MonsterkarteImpl();
        k46.setImage(R.drawable.monstercard13);
        addCardToKartenList(k46);
        Karte k47= new MonsterkarteImpl();
        k47.setImage(R.drawable.monstercard14);
        addCardToKartenList(k47);

        //Adding Rassen cards
        Karte k48= new RassenKarteImpl();
        k48.setImage(R.drawable.rassencard1);
        addCardToKartenList(k48);
        Karte k49= new RassenKarteImpl();
        k49.setImage(R.drawable.rassencard2);
        addCardToKartenList(k49);
        Karte k50= new RassenKarteImpl();
        k50.setImage(R.drawable.rassencard3);
        addCardToKartenList(k50);

    }

    private static void addCardToKartenList(Karte card) {
        KartenList.add(card);
        if(card instanceof RüstungskarteImpl || card instanceof BuffkarteImpl || card instanceof LvlUpKarteImpl) {
            schatzkartenList.add((Schatzkarte) card);
        }
        else
            türKartenList.add((Türkarte)card);
    }

    public HandKarten getHandKarten()
    {
        return handKarten;
    };

    public PlayerAusrüstung getPlayerAusrüstung() {
        return playerAusrüstung;
    }

}
