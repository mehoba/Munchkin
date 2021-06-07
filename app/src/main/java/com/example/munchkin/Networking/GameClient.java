package com.example.munchkin.Networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.munchkin.Activity.MainActivity;
import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Player;
import com.example.munchkin.Spielfeld;

import java.io.IOException;


public class GameClient
{
    private static GameClient instance;

    Boolean successfullyConnected = false;

    Client client;
    public  GameClient()
    {
        instance = this;
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
                                   if (object instanceof Network.NewPlayerJoined) {
                                       Network.NewPlayerJoined newPlayerJoinedClass = (Network.NewPlayerJoined) object;


                                       Lobby.newPlayerJoined(newPlayerJoinedClass.playerData);

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
                                   if (object instanceof Network.NächsterSpielerAnDerReihe)
                                   {
                                       Network.NächsterSpielerAnDerReihe nächsterSpielerAnDerReihe = (Network.NächsterSpielerAnDerReihe)object;
                                       nächsterSpielderIstAnDerReihe(nächsterSpielerAnDerReihe.playerBoardNumber);
                                   }

                                   if(object instanceof Network.KarteAufMonsterSlotGelegt)
                                   {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        Network.KarteAufMonsterSlotGelegt karteAufMonsterSlotGelegt = (Network.KarteAufMonsterSlotGelegt)object;
                                                                                        Spielfeld.getMonsterKartenSlot().karteAblegen(karteAufMonsterSlotGelegt.karte);
                                                                                    }
                                                                                }

                                       );
                                   }

                                   if(object instanceof Network.KarteAufStapelAusgespieltGelegt)
                                   {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        Network.KarteAufStapelAusgespieltGelegt karteAufStapelAusgespieltGelegt = (Network.KarteAufStapelAusgespieltGelegt)object;
                                                                                        Spielfeld.getAusgespielteKartenSlot().karteAblegen(karteAufStapelAusgespieltGelegt.karte);
                                                                                    }
                                                                                }

                                       );
                                   }
                                   if(object instanceof Network.KarteAufAblagestapelGelegt)
                                   {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(new Runnable() {
                                                                                    @Override
                                                                                    public void run() {
                                                                                        Network.KarteAufAblagestapelGelegt karteAufAblagestapelGelegt = (Network.KarteAufAblagestapelGelegt)object;
                                                                                        Karte karte = karteAufAblagestapelGelegt.karte;
                                                                                        if (karte instanceof Schatzkarte) {
                                                                                            Spielfeld.getAblageStapelSchatzkartenSlot().karteAblegenWithoutTrigger(karte);
                                                                                        } else {
                                                                                            Spielfeld.getAblageStapelTürkartenSlot().karteAblegenWithoutTrigger(karte);
                                                                                        }
                                                                                    }
                                                                                }
                                       );
                                   }
                               }
                           }
        );
    }

    void nächsterSpielderIstAnDerReihe(int playerBoardNumber)
    {
        if(Player.getLocalPlayer().getPlayerBoardNumber() == playerBoardNumber)
        {
            //Ich bin dran
            Player.getLocalPlayer().setIstDran(true);
        }
        else
        {
            //wer anders is dran
            Player.getLocalPlayer().setIstDran(false);
        }
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

    public static void sendKarteAutStapelAusgespieltGelegt(Karte karte)
    {
        Network.KarteAufStapelAusgespieltGelegt karteAufStapelAusgespieltGelegt = new Network.KarteAufStapelAusgespieltGelegt();
        karteAufStapelAusgespieltGelegt.karte = karte;

        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(karteAufStapelAusgespieltGelegt);
            }
        }.start();
    }

    public static void sendKarteAufAblagestapelGelegt(Karte karte)
    {
        Network.KarteAufAblagestapelGelegt karteAufAblagestapelGelegt = new Network.KarteAufAblagestapelGelegt();
        karteAufAblagestapelGelegt.karte = karte;

        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(karteAufAblagestapelGelegt);
            }
        }.start();
    }

    public static void sendMonsterKarteGelegtAnServer(Karte karte)
    {
        Network.KarteAufMonsterSlotGelegt karteAufMonsterSlotGelegt = new Network.KarteAufMonsterSlotGelegt();
        karteAufMonsterSlotGelegt.karte = karte;

        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(karteAufMonsterSlotGelegt);
            }
        }.start();
    }

    private static GameClient getInstance() {
        return instance;
    }

//    void connectionWithServerAbgeschlossen()
//    {
//        MainActivity.getInstance().successfullyConnectedToServer();
//    }
}
