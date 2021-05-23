package com.example.munchkin;

import android.util.Log;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.example.munchkin.Networking.Lobby;

import java.io.IOException;

public class GameServer
{
    Server server;
    Lobby lobby = new Lobby();

    public  GameServer() throws IOException
    {
        server = new Server();

        Network.register(server);
        server.addListener(new Listener(){
            @Override
            public void received(Connection connection, Object object)
            {
                if (object instanceof Network.PlayerName)
                {
                    Network.PlayerName playerName = (Network.PlayerName)object;
                    Player player = new Player();
                    player.name = playerName.playerName;
                    player.connectionId = connection.getID();

                    if(!lobby.addPlayer(player))
                    {
                        Log.d("PlayerConnection", "Too much connections: " + player.name);
                    }

                    Log.d("PlayerConnection", "New Connected: " + player.name);

                    Log.d("PlayerConnection", " ");
                    logPlayerList();
                    Log.d("PlayerConnection", " ");


                    sendBoardNumberToClient(player);
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
                if(lobby.removePlayer(connection.getID()))
                {
                    Log.d("PlayerConnection", "disconnected: " + connection.getID());
                    logPlayerList();
                }
            }
        });



        server.bind(Network.port);
        server.start();
    }

    void sendBoardNumberToClient(Player player)
    {
        Network.PlayerBoardNumber playerBoardNumber = new Network.PlayerBoardNumber();
        playerBoardNumber.playerBoardNumber = player.playerBoardNumber;

        server.sendToTCP(player.connectionId, playerBoardNumber);
    }

    void logPlayerList()
    {
        Log.d("PlayerConnection", "PlayerList: ");

        String[] playerNames = lobby.getPlayerNames().toArray(new String[0]);
        for(int i = 0; i < playerNames.length; i++)
        {
            Log.d("PlayerConnection", "       Player: " + playerNames[i]);
        }
    }
}
