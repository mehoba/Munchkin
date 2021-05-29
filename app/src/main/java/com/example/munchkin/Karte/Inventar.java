package com.example.munchkin.Karte;

import com.example.munchkin.R;

import java.util.ArrayList;
import java.util.List;

public class Inventar {




    public List<Karte> getKartenList() {
        return KartenList;
    }
    public List<Karte> getTreasureCardList() {
        return treasureCardList;
    }

    public void setKartenList() {
        KartenList=new ArrayList<>();
        treasureCardList = new ArrayList<>();
        DoorCards= new ArrayList<>();

        KarteImpl k1 = new KarteImpl(CardType.BUFF);

        //Adding Buff Cards
        k1.setImage(R.drawable.buffcard1);
        KarteImpl k2= new KarteImpl(CardType.BUFF);
        k2.setImage(R.drawable.buffcard2);
        addCard(k1);
        addCard(k2);
        KarteImpl k3=new KarteImpl(CardType.BUFF);
        k3.setImage(R.drawable.buffcard3);
        addCard(k3);
        KarteImpl k4= new KarteImpl(CardType.BUFF);
        k4.setImage(R.drawable.buffcard4);
        addCard(k4);
        KarteImpl k5= new KarteImpl(CardType.BUFF);
        k5.setImage(R.drawable.buffcard5);
        addCard(k5);
        KarteImpl k6 = new KarteImpl(CardType.BUFF);
        k6.setImage(R.drawable.buffcard6);
        addCard(k6);

        //Adding level up cards
        KarteImpl k7 = new KarteImpl(CardType.LEVEL_UP);
        k7.setImage(R.drawable.lvlupcard1);
        addCard(k7);
        KarteImpl k8= new KarteImpl(CardType.LEVEL_UP);
        k8.setImage(R.drawable.lvlupcard2);
        addCard(k8);
        KarteImpl k9 = new KarteImpl(CardType.LEVEL_UP);
        k9.setImage(R.drawable.lvlupcard3);
        addCard(k9);
        KarteImpl k10= new KarteImpl(CardType.LEVEL_UP);
        k10.setImage(R.drawable.lvlupcard4);
        addCard(k10);

        //Adding rustungs cards
        KarteImpl k11= new KarteImpl(CardType.ARMOR);
        k11.setImage(R.drawable.rustungcard1);
        addCard(k11);
        KarteImpl k12= new KarteImpl(CardType.ARMOR);
        k12.setImage(R.drawable.rustungcard2);
        addCard(k12);
        KarteImpl k13= new KarteImpl(CardType.ARMOR);
        k13.setImage(R.drawable.rustungcard3);
        addCard(k13);
        KarteImpl k14= new KarteImpl(CardType.ARMOR);
        k14.setImage(R.drawable.rustungcard4);
        addCard(k14);
        KarteImpl k15= new KarteImpl(CardType.ARMOR);
        k15.setImage(R.drawable.rustungcard5);
        addCard(k15);
        KarteImpl k16= new KarteImpl(CardType.ARMOR);
        k16.setImage(R.drawable.rustungcard6);
        addCard(k16);
        KarteImpl k17= new KarteImpl(CardType.ARMOR);
        k17.setImage(R.drawable.rustungcard7);
        addCard(k17);
        KarteImpl k18= new KarteImpl(CardType.ARMOR);
        k18.setImage(R.drawable.rustungcard8);
        addCard(k18);
        KarteImpl k19= new KarteImpl(CardType.ARMOR);
        k19.setImage(R.drawable.rustungcard9);
        addCard(k19);
        KarteImpl k20= new KarteImpl(CardType.ARMOR);
        k20.setImage(R.drawable.rustungcard10);
        addCard(k20);
        KarteImpl k21= new KarteImpl(CardType.ARMOR);
        k21.setImage(R.drawable.rustungcard11);
        addCard(k21);
        KarteImpl k22= new KarteImpl(CardType.ARMOR);
        k22.setImage(R.drawable.rustungcard12);
        addCard(k22);
        KarteImpl k23= new KarteImpl(CardType.ARMOR);
        k23.setImage(R.drawable.rustungcard13);
        addCard(k23);
        KarteImpl k24= new KarteImpl(CardType.ARMOR);
        k24.setImage(R.drawable.rustungcard14);
        addCard(k24);

        //Adding fluch cards
        KarteImpl k25= new KarteImpl(CardType.CURSE);
        k25.setImage(R.drawable.fluchcard1);
        addCard(k25);
        KarteImpl k26= new KarteImpl(CardType.CURSE);
        k26.setImage(R.drawable.fluchcard2);
        addCard(k26);
        KarteImpl k27= new KarteImpl(CardType.CURSE);
        k27.setImage(R.drawable.fluchcard3);
        addCard(k27);
        KarteImpl k28= new KarteImpl(CardType.CURSE);
        k28.setImage(R.drawable.fluchcard4);
        addCard(k28);

        //Adding Klassen cards
        KarteImpl k29= new KarteImpl(CardType.CLASS);
        k29.setImage(R.drawable.klasscard1);
        addCard(k29);
        KarteImpl k30= new KarteImpl(CardType.CLASS);
        k30.setImage(R.drawable.klasscard2);
        addCard(k30);
        KarteImpl k31= new KarteImpl(CardType.CLASS);
        k31.setImage(R.drawable.klasscard3);
        addCard(k31);
        KarteImpl k32= new KarteImpl(CardType.CLASS);
        k32.setImage(R.drawable.klasscard4);
        addCard(k32);

        //Adding monster cards
        Karte k33= new MonsterCardsImpl(2,R.drawable.monstercard1,1,CardType.MONSTER);
        addCard(k33);
        Karte k34= new MonsterCardsImpl(8,R.drawable.monstercard2,1,CardType.MONSTER);
       addCard(k34);
        Karte k35= new MonsterCardsImpl(16,R.drawable.monstercard3,4,CardType.MONSTER);
        addCard(k35);
        Karte k36= new MonsterCardsImpl(8,R.drawable.monstercard4,1,CardType.MONSTER);
        addCard(k36);
        Karte k37= new MonsterCardsImpl(4,R.drawable.monstercard5,5,CardType.MONSTER);
        addCard(k37);
        Karte k38= new MonsterCardsImpl(14,R.drawable.monstercard6,2,CardType.MONSTER);
        addCard(k38);
        Karte k39= new MonsterCardsImpl(2,R.drawable.monstercard7,4,CardType.MONSTER);
        addCard(k39);
        Karte k40= new MonsterCardsImpl(20,R.drawable.monstercard8,2,CardType.MONSTER);
        addCard(k40);
        Karte k41= new MonsterCardsImpl(2,R.drawable.monstercard9,1,CardType.MONSTER);
        addCard(k41);
        Karte k42= new MonsterCardsImpl(1,R.drawable.monstercard10,1,CardType.MONSTER);
        addCard(k42);
        Karte k43= new MonsterCardsImpl(1,R.drawable.monstercard11,4,CardType.MONSTER);
        addCard(k43);
        Karte k44= new MonsterCardsImpl(10,R.drawable.monstercard12,1,CardType.MONSTER);
        addCard(k44);
        Karte k45= new MonsterCardsImpl(14,R.drawable.monstercard13,5,CardType.MONSTER);
        addCard(k45);
        Karte k46= new MonsterCardsImpl(1,R.drawable.monstercard10,0,CardType.MONSTER);
        addCard(k46);
        Karte k47= new MonsterCardsImpl(1,R.drawable.monstercard10,0,CardType.MONSTER);
        addCard(k47);

        //Adding Rassen cards
        KarteImpl k48= new KarteImpl(CardType.RACE);
        k48.setImage(R.drawable.rassencard1);
        addCard(k48);
        KarteImpl k49= new KarteImpl(CardType.RACE);
        k49.setImage(R.drawable.rassencard2);
        addCard(k49);
        KarteImpl k50= new KarteImpl(CardType.RACE);
        k50.setImage(R.drawable.rassencard3);
        addCard(k50);

    }

    private void addCard(Karte card) {
        KartenList.add(card);
        if(card.getCardType() == CardType.ARMOR || card.getCardType() == CardType.BUFF || card.getCardType() == CardType.LEVEL_UP) {
            treasureCardList.add(card);
        }
        else
            DoorCards.add(card);
    }

    public ArrayList<Karte> KartenList;
    public ArrayList<Karte> treasureCardList;

    public ArrayList<Karte> getDoorCards() {
        return DoorCards;
    }

    public ArrayList <Karte> DoorCards;

}
