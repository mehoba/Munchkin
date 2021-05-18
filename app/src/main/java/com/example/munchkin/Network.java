package com.example.munchkin;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network
{
    static public final int port = 25565;
    static public final String ipAdressServer = "192.168.178.1";

    static  public  void register (EndPoint endpoint)
    {
        Kryo kryo = endpoint.getKryo();
        kryo.register(TestClass.class);
        kryo.register(PlayerName.class);
    }

    static public class TestClass
    {
        public String text;
    }

    static public class PlayerName
    {
        public  String playerName;
    }
}
