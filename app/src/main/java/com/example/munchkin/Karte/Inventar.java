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

    public static void initializeKartenList() {
        KartenList=new ArrayList<>();
        schatzkartenList = new ArrayList<>();
        türKartenList = new ArrayList<>();

        //Adding Buff Cards
        Buffkarte k1 = new Buffkarte(R.drawable.buffcard1, 100, 2);
        addCardToKartenList(k1);
        Buffkarte k2= new Buffkarte(R.drawable.buffcard2, 100, 3);
        addCardToKartenList(k2);
        Buffkarte k3=new Buffkarte(R.drawable.buffcard3, 0, 5);
        addCardToKartenList(k3);
        Buffkarte k4= new Buffkarte(R.drawable.buffcard4, 100, 2);
        addCardToKartenList(k4);
        Buffkarte k5= new Buffkarte(R.drawable.buffcard5, 200, 5);
        addCardToKartenList(k5);
        Buffkarte k6 = new Buffkarte(R.drawable.buffcard6, 100, 3);
        addCardToKartenList(k6);

        //Adding level up cards
        LvlUpKarte k7 = new LvlUpKarte(R.drawable.lvlupcard1);
        addCardToKartenList(k7);
        LvlUpKarte k8= new LvlUpKarte(R.drawable.lvlupcard2);
        addCardToKartenList(k8);
        LvlUpKarte k9 = new LvlUpKarte(R.drawable.lvlupcard3);
        addCardToKartenList(k9);
        LvlUpKarte k10= new LvlUpKarte(R.drawable.lvlupcard4);
        addCardToKartenList(k10);

        //Adding rüstungs cards
        Rüstungskarte k11= new Rüstungskarte(R.drawable.rustungcard1, 200, 1, 1, BodyPart.BODY);
        addCardToKartenList(k11);
        Rüstungskarte k12= new Rüstungskarte(R.drawable.rustungcard2, 200, 2, 1, BodyPart.HAND);
        addCardToKartenList(k12);
        Rüstungskarte k13= new Rüstungskarte(R.drawable.rustungcard3, 200, 0, 1,BodyPart.NONE);
        addCardToKartenList(k13);
        Rüstungskarte k14= new Rüstungskarte(R.drawable.rustungcard4, 600, 2, 3, BodyPart.HAND, true);
        addCardToKartenList(k14);
        Rüstungskarte k15= new Rüstungskarte(R.drawable.rustungcard5, 200, 1, 1, BodyPart.HEAD);
        addCardToKartenList(k15);
        Rüstungskarte k16= new Rüstungskarte(R.drawable.rustungcard6, 400, 1, 2,BodyPart.HAND);
        addCardToKartenList(k16);
        Rüstungskarte k17= new Rüstungskarte(R.drawable.rustungcard7, 0, 0,3, BodyPart.NONE);
        addCardToKartenList(k17);
        Rüstungskarte k18= new Rüstungskarte(R.drawable.rustungcard8, 200, 1, 1, BodyPart.BODY);
        addCardToKartenList(k18);
        Rüstungskarte k19= new Rüstungskarte(R.drawable.rustungcard9, 600, 1, 3, BodyPart.HEAD);
        addCardToKartenList(k19);
        Rüstungskarte k20= new Rüstungskarte(R.drawable.rustungcard10, 0, 1, 1, BodyPart.HAND);
        addCardToKartenList(k20);
        Rüstungskarte k21= new Rüstungskarte(R.drawable.rustungcard11, 400, 1, 2, BodyPart.BODY);
        addCardToKartenList(k21);
        Rüstungskarte k22= new Rüstungskarte(R.drawable.rustungcard12, 400, 1,2, BodyPart.FOOT);
        addCardToKartenList(k22);
        Rüstungskarte k23= new Rüstungskarte(R.drawable.rustungcard13, 0, 2, 3, BodyPart.HAND, true);
        addCardToKartenList(k23);
        Rüstungskarte k24= new Rüstungskarte(R.drawable.rustungcard14, 400, 1,2, BodyPart.HAND);
        addCardToKartenList(k24);

        //Adding fluch cards
/*      //TODO: Funktionalität für andere Fluchkarten mittels Klassen abbilden
        Fluchkarte k25= new Fluchkarte(R.drawable.fluchcard1);
        addCardToKartenList(k25);
        Fluchkarte k26= new Fluchkarte(R.drawable.fluchcard2);
        addCardToKartenList(k26);*/
        Fluchkarte k27= new Fluchkarte(R.drawable.fluchcard3, 1);
        addCardToKartenList(k27);
        Fluchkarte k28= new Fluchkarte(R.drawable.fluchcard4, 2);
        addCardToKartenList(k28);

       //Adding Klassen cards
        KlassenKarte k29= new KlassenKarte(R.drawable.klasscard1);
        addCardToKartenList(k29);
        KlassenKarte k30= new KlassenKarte(R.drawable.klasscard2);
        addCardToKartenList(k30);
        KlassenKarte k31= new KlassenKarte(R.drawable.klasscard3);
        addCardToKartenList(k31);
        KlassenKarte k32= new KlassenKarte(R.drawable.klasscard4);
        addCardToKartenList(k32);

        //Adding monster cards
        Monsterkarte k33= new Monsterkarte(R.drawable.monstercard1, 2, 1);
        addCardToKartenList(k33);
        Monsterkarte k34= new Monsterkarte(R.drawable.monstercard2, 8,2);
        addCardToKartenList(k34);
        Monsterkarte k35= new Monsterkarte(R.drawable.monstercard3, 16, 4,2);
        addCardToKartenList(k35);
        Monsterkarte k36= new Monsterkarte(R.drawable.monstercard4, 8,2);
        addCardToKartenList(k36);
        Monsterkarte k37= new Monsterkarte(R.drawable.monstercard5, 4,2);
        addCardToKartenList(k37);
        Monsterkarte k38= new Monsterkarte(R.drawable.monstercard6, 14, 4);
        addCardToKartenList(k38);
        Monsterkarte k39= new Monsterkarte(R.drawable.monstercard7, 2,1);
        addCardToKartenList(k39);
        Monsterkarte k40= new Monsterkarte(R.drawable.monstercard8, 20,5,2);
        addCardToKartenList(k40);
        Monsterkarte k41= new Monsterkarte(R.drawable.monstercard9, 2,1);
        addCardToKartenList(k41);
        //Karte k42 war 9 und wäre somit doppelt
        Monsterkarte k43= new Monsterkarte(R.drawable.monstercard10, 1,1);
        addCardToKartenList(k43);
        Monsterkarte k44= new Monsterkarte(R.drawable.monstercard11, 1,1);
        addCardToKartenList(k44);
        Monsterkarte k45= new Monsterkarte(R.drawable.monstercard12, 10,3);
        addCardToKartenList(k45);
        Monsterkarte k46= new Monsterkarte(R.drawable.monstercard13, 14,4);
        addCardToKartenList(k46);
        Monsterkarte k47= new Monsterkarte(R.drawable.monstercard14, 1,1);
        addCardToKartenList(k47);

        //Adding Rassen cards
        RassenKarte k48= new RassenKarte(R.drawable.rassencard1);
        addCardToKartenList(k48);
        RassenKarte k49= new RassenKarte(R.drawable.rassencard2);
        addCardToKartenList(k49);
        RassenKarte k50= new RassenKarte(R.drawable.rassencard3);
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
