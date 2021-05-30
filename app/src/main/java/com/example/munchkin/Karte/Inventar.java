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



        //Adding Buff Cards
        Karte k1 = new BuffCardsImpl(R.drawable.buffcard1,CardType.BUFF,2,2);
        addCard(k1);
        Karte k2 = new BuffCardsImpl(R.drawable.buffcard2,CardType.BUFF,3,3);
        addCard(k2);
        Karte k3 = new BuffCardsImpl(R.drawable.buffcard3,CardType.BUFF,5,5);
        addCard(k3);
        Karte k4 = new BuffCardsImpl(R.drawable.buffcard4,CardType.BUFF,2,2);
        addCard(k4);
        Karte k5 = new BuffCardsImpl(R.drawable.buffcard5,CardType.BUFF,5,5);
        addCard(k5);
        Karte k6 = new BuffCardsImpl(R.drawable.buffcard6,CardType.BUFF,3,3);
        addCard(k6);

        //Adding level up cards
        Karte k7 = new LvlUpCardsImpl(R.drawable.lvlupcard1,CardType.LEVEL_UP);
        addCard(k7);
        Karte k8 = new LvlUpCardsImpl(R.drawable.lvlupcard2,CardType.LEVEL_UP);
        addCard(k8);
        Karte k9 = new LvlUpCardsImpl(R.drawable.lvlupcard3,CardType.LEVEL_UP);
        addCard(k9);
        Karte k10 = new LvlUpCardsImpl(R.drawable.lvlupcard4,CardType.LEVEL_UP);
        addCard(k10);

        //Adding rustungs cards
        Karte k11= new RustungCardsImpl(R.drawable.rustungcard1,CardType.ARMOR,1,1,BodyPart.BODY);
        addCard(k11);
        Karte k12= new RustungCardsImpl(R.drawable.rustungcard2,CardType.ARMOR,2,1,BodyPart.HAND);
        addCard(k12);
        Karte k13= new RustungCardsImpl(R.drawable.rustungcard3,CardType.ARMOR,1,1,BodyPart.BODY);
        addCard(k13);
        Karte k14= new RustungCardsImpl(R.drawable.rustungcard4,CardType.ARMOR,2,3,BodyPart.HAND);
        addCard(k14);
        Karte k15= new RustungCardsImpl(R.drawable.rustungcard5,CardType.ARMOR,1,1,BodyPart.BODY);
        addCard(k15);
        Karte k16= new RustungCardsImpl(R.drawable.rustungcard6,CardType.ARMOR,1,2,BodyPart.HAND);
        addCard(k16);
        Karte k17= new RustungCardsImpl(R.drawable.rustungcard7,CardType.ARMOR,1,3,BodyPart.BODY);
        addCard(k17);
        Karte k18= new RustungCardsImpl(R.drawable.rustungcard8,CardType.ARMOR,1,1,BodyPart.BODY);
        addCard(k18);
        Karte k19= new RustungCardsImpl(R.drawable.rustungcard9,CardType.ARMOR,1,1,BodyPart.HEAD);
        addCard(k19);
        Karte k20= new RustungCardsImpl(R.drawable.rustungcard10,CardType.ARMOR,1,1,BodyPart.HAND);
        addCard(k20);
        Karte k21= new RustungCardsImpl(R.drawable.rustungcard11,CardType.ARMOR,1,2,BodyPart.BODY);
        addCard(k21);
        Karte k22= new RustungCardsImpl(R.drawable.rustungcard12,CardType.ARMOR,1,2,BodyPart.FOOT);
        addCard(k22);
        Karte k23= new RustungCardsImpl(R.drawable.rustungcard13,CardType.ARMOR,2,3,BodyPart.HAND);
        addCard(k23);
        Karte k24= new RustungCardsImpl(R.drawable.rustungcard14,CardType.ARMOR,1,2,BodyPart.HAND);
        addCard(k24);

        //Adding fluch cards
        Karte k25 = new FluchCardsImpl(R.drawable.fluchcard1, CardType.CURSE, 0,BodyPart.FOOT);
        addCard(k25);
        Karte k26 = new FluchCardsImpl(R.drawable.fluchcard2, CardType.CURSE, 0,BodyPart.HEAD);
        addCard(k26);
        Karte k27 = new FluchCardsImpl(R.drawable.fluchcard3, CardType.CURSE, 1, null);
        addCard(k27);
        Karte k28 = new FluchCardsImpl(R.drawable.fluchcard4, CardType.CURSE, 2,null);
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
