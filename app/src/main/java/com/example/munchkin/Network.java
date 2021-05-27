package com.example.munchkin;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Networking.Lobby;

public class Network
{
    static public final int port = 25565;
    static public String ipAdressServer = "192.168.178.22";

    static  public  void register (EndPoint endpoint)
    {
        Kryo kryo = endpoint.getKryo();
        kryo.register(LoginNewPlayerForServer.class);
        kryo.register(Lobby.class);
        kryo.register(SyncPlayers.class);

        kryo.register(Player[].class);
        kryo.register(Player.class);
        kryo.register(Inventar.class);
        kryo.register(Level.class);
        kryo.register(Karte.class);
        kryo.register(KartenSlot.class);
        kryo.register(PlayerAusrüstung.class);
        kryo.register(HandKarten.class);
        kryo.register(SendLocalPlayer.class);
    }

    static public class LoginNewPlayerForServer
    {
        public String playerName;
    }

    static public class SyncPlayers
    {
        public Player[] players;
    }

    static public class SendLocalPlayer
    {
        public int localPlayerIndex;
    }
}
