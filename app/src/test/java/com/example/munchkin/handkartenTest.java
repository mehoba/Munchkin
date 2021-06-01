package com.example.munchkin;

import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenTypen.BuffkarteImpl;
import com.example.munchkin.Networking.Lobby;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class handkartenTest {

    private Inventar inventar;
    private HandKarten handkarten;
    private Karte k1,k2,k3,k4,k5,k6,k7,k8;


    @Before
    public void setUp() throws Exception
    {
        inventar=new Inventar();
        handkarten=new HandKarten();
        Player.setLocalPlayer(new Player());
        if(Lobby.getInstance() == null) {
            Lobby.setInstance(new Lobby());
        }
        Lobby.addPlayer(Player.getLocalPlayer(), 0);
    }

    @Test
    public void checkIfMoreThan7Test(){
        k1=new BuffkarteImpl();
        k2=new BuffkarteImpl();
        k3=new BuffkarteImpl();
        k4=new BuffkarteImpl();
        k5=new BuffkarteImpl();
        k6=new BuffkarteImpl();
        k7=new BuffkarteImpl();
        k8=new BuffkarteImpl();
        Karte[] array = {k1,k2,k3,k4,k5,k6,k7,k8};
        handkarten.addKarte(array);
        Assert.assertEquals(false,handkarten.checkIfNotMoreThan4());
    }

    @Test
    public void checkIfMoreThan7Test2(){
        k1=new BuffkarteImpl();
        Karte[] array = {k1};
        handkarten.addKarte(array);
        Assert.assertEquals(true, handkarten.checkIfNotMoreThan4());
    }

    @Test
    public void checkNotMoreThan5(){
        k1=new BuffkarteImpl();
        k2=new BuffkarteImpl();
        k3=new BuffkarteImpl();
        k4=new BuffkarteImpl();
        k5=new BuffkarteImpl();
        k6=new BuffkarteImpl();
        k7=new BuffkarteImpl();
        k8=new BuffkarteImpl();
        Karte[] array = {k1,k2,k3,k4,k5,k6,k7,k8};
        handkarten.addKarte(array);
        handkarten.onFinishRound();
        Assert.assertEquals(handkarten.countHandkarten(), 5);
    }

    @After
    public void cleanUp(){
        handkarten = null;
    }
}
