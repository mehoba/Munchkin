package com.example.munchkin.Networking;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;
import com.example.munchkin.Karte.BodyPart;
import com.example.munchkin.Karte.HandKarten;
import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Karte.KartenTypen.BuffkarteImpl;
import com.example.munchkin.Karte.KartenTypen.FluchkarteImpl;
import com.example.munchkin.Karte.KartenTypen.KlassenKarteImpl;
import com.example.munchkin.Karte.KartenTypen.LevelUpKarte;
import com.example.munchkin.Karte.KartenTypen.LvlUpKarteImpl;
import com.example.munchkin.Karte.KartenTypen.MonsterKarte;
import com.example.munchkin.Karte.KartenTypen.MonsterkarteImpl;
import com.example.munchkin.Karte.KartenTypen.RassenKarte;
import com.example.munchkin.Karte.KartenTypen.RassenKarteImpl;
import com.example.munchkin.Karte.KartenTypen.RüstungskarteImpl;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Karte.KartenTypen.SchatzkarteImpl;
import com.example.munchkin.Karte.KartenTypen.TürkarteImpl;
import com.example.munchkin.Level;
import com.example.munchkin.Networking.Lobby;
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
        kryo.register(MonsterkarteImpl.class);
        kryo.register(KlassenKarteImpl.class);
        kryo.register(BuffkarteImpl.class);
        kryo.register(FluchkarteImpl.class);
        kryo.register(LvlUpKarteImpl.class);
        kryo.register(MonsterkarteImpl.class);
        kryo.register(RassenKarteImpl.class);
        kryo.register(RüstungskarteImpl.class);
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
