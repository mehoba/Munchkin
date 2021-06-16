package com.example.munchkin.Networking;

import android.util.Log;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerData;

import java.io.IOException;

public class GameServer
{
    Server server;
    public static Boolean startWithClient = false;

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

                    sendNewPlayerJoined(player);//send to all players(except the new one) the new player
                    syncNewPlayer(player);//sends all the players to the new player

                    //1. Spieler -> Soll dran sein
                    if(player.getPlayerBoardNumber() == 0)
                    {
                        broadcastPlayerIstDran(player);
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

                if (object instanceof Network.KarteAufStapelAusgespieltGelegt)
                {
                    Network.KarteAufStapelAusgespieltGelegt karteAufStapelAusgespieltGelegt = (Network.KarteAufStapelAusgespieltGelegt)object;
                    server.sendToAllExceptTCP(connection.getID(), karteAufStapelAusgespieltGelegt);
                }
                if (object instanceof Network.KarteAufAblagestapelGelegt)
                {
                    Network.KarteAufAblagestapelGelegt karteAufAblagestapelGelegt = (Network.KarteAufAblagestapelGelegt)object;
                    server.sendToAllExceptTCP(connection.getID(), karteAufAblagestapelGelegt);
                }
                if (object instanceof Network.NächsterSpielerAnDerReihe)
                {
                    Network.NächsterSpielerAnDerReihe nächsterSpielerAnDerReihe = (Network.NächsterSpielerAnDerReihe)object;
                    Player playerNow = Lobby.getPlayer(nächsterSpielerAnDerReihe.playerBoardNumber);
                    nächsterSpielerAnDerReihe.playerBoardNumber = Lobby.getNextPlayer(playerNow).getPlayerBoardNumber();

                    server.sendToAllTCP(nächsterSpielerAnDerReihe);
                }
                if (object instanceof Network.PlayerLevel)
                {
                    Network.PlayerLevel playerLevel = (Network.PlayerLevel)object;
                    server.sendToAllExceptTCP(playerLevel.playerData.getConnectionId(), playerLevel);
                    Log.i("lvl", "Send PlayerLevel from lvl Player: " + playerLevel.playerData.getName() + " to lvl " + playerLevel.level);
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

    void sendNewPlayerJoined(Player newPlayer)
    {
        Network.NewPlayerJoined newPlayerJoined = new Network.NewPlayerJoined();
        newPlayerJoined.playerData = PlayerData.convertToPlayerData(newPlayer);
        server.sendToAllExceptTCP(newPlayer.getConnectionId(), newPlayerJoined);
    }

    void syncNewPlayer(Player player)
    {
        Network.SyncLobbyForNewPlayer syncLobbyForNewPlayerClass = new Network.SyncLobbyForNewPlayer();
        syncLobbyForNewPlayerClass.localPlayerIndex = player.getPlayerBoardNumber();
        syncLobbyForNewPlayerClass.playerDataArr = PlayerData.converToPlayerData(Lobby.getPlayers());
        server.sendToTCP(player.getConnectionId(), syncLobbyForNewPlayerClass);
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

    void broadcastPlayerIstDran(Player player)
    {
        Network.NächsterSpielerAnDerReihe nächsterSpielerAnDerReihe = new Network.NächsterSpielerAnDerReihe();
        nächsterSpielerAnDerReihe.playerBoardNumber = player.getPlayerBoardNumber();
        server.sendToAllTCP(nächsterSpielerAnDerReihe);
    }
}
