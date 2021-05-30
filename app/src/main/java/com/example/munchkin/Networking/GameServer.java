package com.example.munchkin.Networking;

import android.util.Log;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Networking.Network;
import com.example.munchkin.Player;

import java.io.IOException;

public class GameServer
{
    Server server;

    public  GameServer() throws IOException
    {
        server = new Server();

        Network.register(server);
        server.addListener(new Listener(){
            @Override
            public void received(Connection connection, Object object)
            {
                if (object instanceof Network.LoginNewPlayerForServer)
                {
                    Network.LoginNewPlayerForServer loginNewPlayer = (Network.LoginNewPlayerForServer)object;
                    Player player = new Player();
                    player.setName(loginNewPlayer.playerName);
                    player.setConnectionId(connection.getID());

                    int playerPosInArray = Lobby.addPlayerAtFreePosition(player);
                    if(playerPosInArray == -1)
                    {
                        Log.d("PlayerConnection", "Too much connections: " + player.getName());
                        return;
                    }
                    player.setPlayerBoardNumber(playerPosInArray);

                    syncPlayers();
                    sendLocalPlayer(player);

                    //1. Spieler -> Soll dran sein
                    if(player.getPlayerBoardNumber() == 0)
                    {
                        boradcastPlayerIstDran(player);
                    }

                    Log.d("PlayerConnection", "New Connected: " + player.getName());

                    Log.d("PlayerConnection", " ");
                    logPlayerList();
                    Log.d("PlayerConnection", " ");
                }

                if (object instanceof Network.KarteAufMonsterSlotGelegt)
                {
                    Network.KarteAufMonsterSlotGelegt karteAufMonsterSlotGelegt = (Network.KarteAufMonsterSlotGelegt)object;
                    server.sendToAllExceptTCP(connection.getID(), karteAufMonsterSlotGelegt);
                }
            }

            @Override
            public void connected(Connection connection)
            {
//                Network.TestClass test = new Network.TestClass();
//                test.text = "Dies ist ein Serialisiertes Objekt";
//
//                server.sendToTCP(connection.getID(), test);
            }

            @Override
            public void disconnected(Connection connection)
            {
                if(Lobby.removePlayer(connection.getID()))
                {
                    Log.d("PlayerConnection", "disconnected: " + connection.getID());
                    logPlayerList();

                    //ToDo remove Player
                }
            }
        });



        server.bind(Network.port);
        server.start();
    }

    void syncPlayers()
    {
        Network.SyncPlayers syncPlayers = new Network.SyncPlayers();
        syncPlayers.players = Lobby.getPlayers();
        server.sendToAllTCP(syncPlayers);
    }

    void sendLocalPlayer(Player player)
    {
        Network.SendLocalPlayer sendLocalPlayerClass = new Network.SendLocalPlayer();
        sendLocalPlayerClass.localPlayerIndex = player.getPlayerBoardNumber();

        server.sendToTCP(player.getConnectionId(), sendLocalPlayerClass);
    }

    void logPlayerList()
    {
        Log.d("PlayerConnection", "PlayerList: ");

        String[] playerNames = Lobby.getPlayerNames().toArray(new String[0]);
        for(int i = 0; i < playerNames.length; i++)
        {
            Log.d("PlayerConnection", "       Player: " + playerNames[i]);
        }
    }

    void boradcastPlayerIstDran(Player player)
    {
        Network.NächsterSpielerAnDerReihe nächsterSpielerAnDerReihe = new Network.NächsterSpielerAnDerReihe();
        nächsterSpielerAnDerReihe.playerBoardNumber = player.getPlayerBoardNumber();
        server.sendToAllTCP(nächsterSpielerAnDerReihe);
    }
}