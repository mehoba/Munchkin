package com.example.munchkin;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.munchkin.Networking.Lobby;

import java.io.IOException;


public class GameClient
{
    Client client;
    public  GameClient()
    {
        client  = new Client();
        client.start();

        Network.register(client);

        client.addListener(new Listener()
                           {
                               @Override
                               public void connected(Connection connection)
                               {
                                   //MainActivity.AddText("Connected");

                               }

                               @Override
                               public void disconnected(Connection connection)
                               {
                                   //MainActivity.SetText("disconnected");
                               }

                               @Override
                               public void received(Connection connection, Object object)
                               {
                                   if (object instanceof Network.PlayerBoardNumber)
                                   {
                                       Network.PlayerBoardNumber playerBoardNumber = (Network.PlayerBoardNumber)object;
                                       boardNumberRecievedFromServer(playerBoardNumber);
                                   }
                               }
                           }

        );
    }

    public void connectToServer(final String ipAddress, final String playerName)
    {
        new Thread("Connect")
        {
            public void run () {
                try
                {
                    if(!client.isConnected())
                    {
                        Network.ipAdressServer = ipAddress;
                        client.connect(5000, Network.ipAdressServer, Network.port);
                    }
                    sendPlayerNameToServer(playerName);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    public void sendPlayerNameToServer(String name)
    {
        Network.PlayerName playerName = new Network.PlayerName();
        playerName.playerName = name;
        client.sendTCP(playerName);
    }

    void boardNumberRecievedFromServer(Network.PlayerBoardNumber playerBoardNumber)
    {
        MainActivity.getInstance().successfullyConnectedToServer();
        //playerBoardNumber to be implemented......
    }
}
