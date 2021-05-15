package com.example.munchkin;

import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KarteImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class handkartenTest {

    private Inventar inventar;
    private HandKarten handkarten;
    private Karte k1,k2,k3,k4,k5,k6,k7,k8;


    @Before
    public void setUp() throws Exception{
    inventar=new Inventar();
   handkarten=new HandKarten();

    }

    @Test
    public void checkIfMoreThan7Test(){

        k1=new KarteImpl();
        k2=new KarteImpl();
        k3=new KarteImpl();
        k4=new KarteImpl();
        k5=new KarteImpl();
        k6=new KarteImpl();
        k7=new KarteImpl();
        k8=new KarteImpl();
        Karte[] array = {k1,k2,k3,k4,k5,k6,k7,k8};
       handkarten.setHandKarten(Arrays.asList(array));
        Assert.assertEquals(true,handkarten.checkIfMoreThan7());
    }

    @Test
    public void checkIfMoreThan7Test2(){
        k1=new KarteImpl();
        Karte[] array = {k1};
        handkarten.setHandKarten(Arrays.asList(array));
        Assert.assertEquals(false,handkarten.checkIfMoreThan7());
    }

    @After
    public void cleanUp(){
        handkarten.setHandKarten(null);
    }
}
