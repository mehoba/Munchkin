package com.example.munchkin.Karte;

import com.example.munchkin.Karte.KartenTypen.Buffkarte;
import com.example.munchkin.Karte.KartenTypen.Fluchkarte;
import com.example.munchkin.Karte.KartenTypen.KlassenKarte;
import com.example.munchkin.Karte.KartenTypen.LvlUpKarte;
import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
import com.example.munchkin.Karte.KartenTypen.RassenKarte;
import com.example.munchkin.Karte.KartenTypen.Rüstungskarte;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Karte.KartenTypen.Türkarte;
import com.example.munchkin.PlayerAusrüstung;
import com.example.munchkin.R;
import com.example.munchkin.Activity.SpielfeldActivity;

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

        Karte k1 = new Buffkarte();

        //Adding Buff Cards
        k1.setImage(R.drawable.buffcard1);
        Karte k2= new Buffkarte();
        k2.setImage(R.drawable.buffcard2);
        addCardToKartenList(k1);
        addCardToKartenList(k2);
        Karte k3=new Buffkarte();
        k3.setImage(R.drawable.buffcard3);
        addCardToKartenList(k3);
        Karte k4= new Buffkarte();
        k4.setImage(R.drawable.buffcard4);
        addCardToKartenList(k4);
        Karte k5= new Buffkarte();
        k5.setImage(R.drawable.buffcard5);
        addCardToKartenList(k5);
        Karte k6 = new Buffkarte();
        k6.setImage(R.drawable.buffcard6);
        addCardToKartenList(k6);

        //Adding level up cards
        Karte k7 = new LvlUpKarte();
        k7.setImage(R.drawable.lvlupcard1);
        addCardToKartenList(k7);
        Karte k8= new LvlUpKarte();
        k8.setImage(R.drawable.lvlupcard2);
        addCardToKartenList(k8);
        Karte k9 = new LvlUpKarte();
        k9.setImage(R.drawable.lvlupcard3);
        addCardToKartenList(k9);
        Karte k10= new LvlUpKarte();
        k10.setImage(R.drawable.lvlupcard4);
        addCardToKartenList(k10);

        //Adding rustungs cards
        Karte k11= new Rüstungskarte();
        k11.setImage(R.drawable.rustungcard1);
        addCardToKartenList(k11);
        Karte k12= new Rüstungskarte();
        k12.setImage(R.drawable.rustungcard2);
        addCardToKartenList(k12);
        Karte k13= new Rüstungskarte();
        k13.setImage(R.drawable.rustungcard3);
        addCardToKartenList(k13);
        Karte k14= new Rüstungskarte();
        k14.setImage(R.drawable.rustungcard4);
        addCardToKartenList(k14);
        Karte k15= new Rüstungskarte();
        k15.setImage(R.drawable.rustungcard5);
        addCardToKartenList(k15);
        Karte k16= new Rüstungskarte();
        k16.setImage(R.drawable.rustungcard6);
        addCardToKartenList(k16);
        Karte k17= new Rüstungskarte();
        k17.setImage(R.drawable.rustungcard7);
        addCardToKartenList(k17);
        Karte k18= new Rüstungskarte();
        k18.setImage(R.drawable.rustungcard8);
        addCardToKartenList(k18);
        Karte k19= new Rüstungskarte();
        k19.setImage(R.drawable.rustungcard9);
        addCardToKartenList(k19);
        Karte k20= new Rüstungskarte();
        k20.setImage(R.drawable.rustungcard10);
        addCardToKartenList(k20);
        Karte k21= new Rüstungskarte();
        k21.setImage(R.drawable.rustungcard11);
        addCardToKartenList(k21);
        Karte k22= new Rüstungskarte();
        k22.setImage(R.drawable.rustungcard12);
        addCardToKartenList(k22);
        Karte k23= new Rüstungskarte();
        k23.setImage(R.drawable.rustungcard13);
        addCardToKartenList(k23);
        Karte k24= new Rüstungskarte();
        k24.setImage(R.drawable.rustungcard14);
        addCardToKartenList(k24);

        //Adding fluch cards
        Karte k25= new Fluchkarte();
        k25.setImage(R.drawable.fluchcard1);
        addCardToKartenList(k25);
        Karte k26= new Fluchkarte();
        k26.setImage(R.drawable.fluchcard2);
        addCardToKartenList(k26);
        Karte k27= new Fluchkarte();
        k27.setImage(R.drawable.fluchcard3);
        addCardToKartenList(k27);
        Karte k28= new Fluchkarte();
        k28.setImage(R.drawable.fluchcard4);
        addCardToKartenList(k28);

        //Adding Klassen cards
        Karte k29= new KlassenKarte();
        k29.setImage(R.drawable.klasscard1);
        addCardToKartenList(k29);
        Karte k30= new KlassenKarte();
        k30.setImage(R.drawable.klasscard2);
        addCardToKartenList(k30);
        Karte k31= new KlassenKarte();
        k31.setImage(R.drawable.klasscard3);
        addCardToKartenList(k31);
        Karte k32= new KlassenKarte();
        k32.setImage(R.drawable.klasscard4);
        addCardToKartenList(k32);

        //Adding monster cards
        Monsterkarte k33= new Monsterkarte();
        k33.setImage(R.drawable.monstercard1);
        k33.setMonsterLevel(2);
        k33.setAnzahlSchätze(1);
        addCardToKartenList(k33);

        Monsterkarte k34= new Monsterkarte();
        k34.setImage(R.drawable.monstercard2);
        k34.setMonsterLevel(8);
        k34.setAnzahlSchätze(2);
        addCardToKartenList(k34);

        Monsterkarte k35= new Monsterkarte();
        k35.setImage(R.drawable.monstercard3);
        k35.setMonsterLevel(16);
        k35.setAnzahlSchätze(4);
        k35.setGewonneneLevel(2);
        addCardToKartenList(k35);

        Monsterkarte k36= new Monsterkarte();
        k36.setImage(R.drawable.monstercard4);
        k36.setMonsterLevel(8);
        k36.setAnzahlSchätze(2);
        addCardToKartenList(k36);

        Monsterkarte k37= new Monsterkarte();
        k37.setImage(R.drawable.monstercard5);
        k37.setMonsterLevel(4);
        k37.setAnzahlSchätze(2);
        addCardToKartenList(k37);

        Monsterkarte k38= new Monsterkarte();
        k38.setImage(R.drawable.monstercard6);
        k38.setMonsterLevel(14);
        k38.setAnzahlSchätze(4);
        addCardToKartenList(k38);

        Monsterkarte k39= new Monsterkarte();
        k39.setImage(R.drawable.monstercard7);
        k39.setMonsterLevel(2);
        k39.setAnzahlSchätze(1);
        addCardToKartenList(k39);

        Monsterkarte k40= new Monsterkarte();
        k40.setImage(R.drawable.monstercard8);
        k40.setMonsterLevel(20);
        k40.setAnzahlSchätze(5);
        k40.setGewonneneLevel(2);
        addCardToKartenList(k40);

        Monsterkarte k41= new Monsterkarte();
        k41.setImage(R.drawable.monstercard9);
        k41.setMonsterLevel(2);
        k41.setAnzahlSchätze(1);
        addCardToKartenList(k41);

//        //Karte 9 wäre doppelt
//        Karte k42= new MonsterkarteImpl();
//        k42.setImage(R.drawable.monstercard9);
//        addCardToKartenList(k42);

        Monsterkarte k43= new Monsterkarte();
        k43.setImage(R.drawable.monstercard10);
        k43.setMonsterLevel(1);
        k43.setAnzahlSchätze(1);
        addCardToKartenList(k43);

        Monsterkarte k44= new Monsterkarte();
        k44.setImage(R.drawable.monstercard11);
        k44.setMonsterLevel(1);
        k44.setAnzahlSchätze(1);
        addCardToKartenList(k44);

        Monsterkarte k45= new Monsterkarte();
        k45.setImage(R.drawable.monstercard12);
        k45.setMonsterLevel(10);
        k45.setAnzahlSchätze(3);
        addCardToKartenList(k45);

        Monsterkarte k46= new Monsterkarte();
        k46.setImage(R.drawable.monstercard13);
        k46.setMonsterLevel(14);
        k46.setAnzahlSchätze(4);
        addCardToKartenList(k46);

        Monsterkarte k47= new Monsterkarte();
        k47.setImage(R.drawable.monstercard14);
        k47.setMonsterLevel(1);
        k47.setAnzahlSchätze(1);
        addCardToKartenList(k47);


        //Adding Rassen cards
        Karte k48= new RassenKarte();
        k48.setImage(R.drawable.rassencard1);
        addCardToKartenList(k48);
        Karte k49= new RassenKarte();
        k49.setImage(R.drawable.rassencard2);
        addCardToKartenList(k49);
        Karte k50= new RassenKarte();
        k50.setImage(R.drawable.rassencard3);
        addCardToKartenList(k50);

    }

    private static void addCardToKartenList(Karte card) {
        KartenList.add(card);
        if(card instanceof Rüstungskarte || card instanceof Buffkarte || card instanceof LvlUpKarte) {
            schatzkartenList.add((Schatzkarte) card);
        }
        else
            türKartenList.add((Türkarte)card);
    }

    public HandKarten getHandKarten()
    {
        return handKarten;
    }

    public PlayerAusrüstung getPlayerAusrüstung() {
        return playerAusrüstung;
    }

}
