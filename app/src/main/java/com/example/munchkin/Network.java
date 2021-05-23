package com.example.munchkin;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network
{
    static public final int port = 25565;
    static public String ipAdressServer = "192.168.178.22";

    static  public  void register (EndPoint endpoint)
    {
        Kryo kryo = endpoint.getKryo();
        kryo.register(PlayerName.class);
        kryo.register(PlayerBoardNumber.class);
    }

    static public class PlayerName
    {
        public String playerName;
    }

    static public class PlayerBoardNumber
    {
        public int playerBoardNumber;
    }
}
