package com.example.munchkin.Networking;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.example.munchkin.Karte.BodyPart;
import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Karte.KartenTypen.Buffkarte;
import com.example.munchkin.Karte.KartenTypen.Fluchkarte;
import com.example.munchkin.Karte.KartenTypen.KlassenKarte;
import com.example.munchkin.Karte.KartenTypen.LvlUpKarte;
import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
import com.example.munchkin.Karte.KartenTypen.RassenKarte;
import com.example.munchkin.Karte.KartenTypen.Rüstungskarte;
import com.example.munchkin.Karte.KartenTypen.SchatzkarteImpl;
import com.example.munchkin.Karte.KartenTypen.TürkarteImpl;
import com.example.munchkin.Level;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerAusrüstung;

public class Network
{
    static public final int port = 25565;
    static public String ipAdressServer = "192.168.178.21";

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
        kryo.register(NächsterSpielerAnDerReihe.class);
        kryo.register(KartenSlot[].class);
        kryo.register(KarteAufMonsterSlotGelegt.class);
        kryo.register(Monsterkarte.class);
        kryo.register(KlassenKarte.class);
        kryo.register(Buffkarte.class);
        kryo.register(Fluchkarte.class);
        kryo.register(LvlUpKarte.class);
        kryo.register(Monsterkarte.class);
        kryo.register(RassenKarte.class);
        kryo.register(Rüstungskarte.class);
        kryo.register(SchatzkarteImpl.class);
        kryo.register(TürkarteImpl.class);
        kryo.register(BodyPart.class);
        kryo.register(KarteAufAbgelegtSlotGelegt.class);
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

    static public class NächsterSpielerAnDerReihe
    {
        public int playerBoardNumber;
    }

    static public class KarteAufMonsterSlotGelegt
    {
        public Karte karte;
    }

    static public class KarteAufAbgelegtSlotGelegt
    {
        public Karte karte;
    }
}
