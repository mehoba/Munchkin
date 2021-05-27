package com.example.munchkin;

import android.util.Log;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.munchkin.Networking.Lobby;

import java.io.IOException;


public class GameClient
{
    Boolean successfullyConnected = false;

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
                                   if (object instanceof Network.SyncPlayers) {
                                       Network.SyncPlayers syncPlayersClass = (Network.SyncPlayers) object;

                                       Lobby.syncPlayers(syncPlayersClass.players);

                                       if (SpielfeldActivity.getInstance() != null)
                                           SpielfeldActivity.getInstance().setPlayerNames();
                                   }

                                   if (object instanceof Network.SendLocalPlayer)
                                   {
                                       try {
                                           Thread.sleep(1000);
                                       } catch (InterruptedException e) {
                                           e.printStackTrace();
                                       }

                                       Network.SendLocalPlayer sendLocalPlayerClass = (Network.SendLocalPlayer)object;
                                       Player player = Lobby.getPlayer(sendLocalPlayerClass.localPlayerIndex);
                                       Player.setLocalPlayer(player);
                                       MainActivity.getInstance().successfullyConnectedToServer();
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
                    loginToServer(playerName);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    public void loginToServer(String name)
    {
        Network.LoginNewPlayerForServer loginNewPlayer = new Network.LoginNewPlayerForServer();
        loginNewPlayer.playerName = name;
        client.sendTCP(loginNewPlayer);
    }

//    void connectionWithServerAbgeschlossen()
//    {
//        MainActivity.getInstance().successfullyConnectedToServer();
//    }
}
