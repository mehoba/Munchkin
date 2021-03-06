package com.example.munchkin.Networking;

import android.widget.Toast;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.example.munchkin.Activity.MainActivity;
import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.GamePhase;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerData;
import com.example.munchkin.Spielfeld;

import java.io.IOException;


public class GameClient
{
    private static GameClient instance;

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
                                   }

                                   if (object instanceof Network.SyncLobbyForNewPlayer)
                                   {
                                       Network.SyncLobbyForNewPlayer syncLobbyForNewPlayerClass = (Network.SyncLobbyForNewPlayer)object;
//                                       Player player = Lobby.getPlayer(syncLobbyForNewPlayerClass.localPlayerIndex);
//                                       Player.setLocalPlayer(player);
                                       Lobby.syncLobby(syncLobbyForNewPlayerClass);
                                       MainActivity.getInstance().successfullyConnectedToServer();
                                   }
                                   if (object instanceof Network.N??chsterSpielerAnDerReihe)
                                   {
                                       Network.N??chsterSpielerAnDerReihe n??chsterSpielerAnDerReihe = (Network.N??chsterSpielerAnDerReihe)object;
                                       n??chsterSpielderIstAnDerReihe(n??chsterSpielerAnDerReihe.playerBoardNumber);
                                       Player spielerAnDerReihe = Lobby.getPlayer(n??chsterSpielerAnDerReihe.playerBoardNumber);
                                       if(spielerAnDerReihe != null && SpielfeldActivity.getInstance() != null)
                                       {
                                           SpielfeldActivity.getInstance().runOnUiThread(() -> {
                                               String text = "Spieler " + spielerAnDerReihe.getName() + " ist an der Reihe";
                                               Toast.makeText(SpielfeldActivity.getInstance(), text, Toast.LENGTH_SHORT).show();
                                           });
                                       }
                                   }

                                   if(object instanceof Network.KarteAufMonsterSlotGelegt)
                                   {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(() -> {
                                           Network.KarteAufMonsterSlotGelegt karteAufMonsterSlotGelegt = (Network.KarteAufMonsterSlotGelegt)object;
                                           Spielfeld.getMonsterKartenSlot().karteAblegenWithoutTrigger(karteAufMonsterSlotGelegt.karte);
                                       }

                                       );
                                   }

                                   if(object instanceof Network.KarteAufStapelAusgespieltGelegt)
                                   {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(() -> {
                                           Network.KarteAufStapelAusgespieltGelegt karteAufStapelAusgespieltGelegt = (Network.KarteAufStapelAusgespieltGelegt)object;
                                           Spielfeld.getAusgespielteKartenSlot().karteAblegenWithoutTrigger(karteAufStapelAusgespieltGelegt.karte);
                                       }

                                       );
                                   }
                                   if(object instanceof Network.KarteAufAblagestapelGelegt) {
                                       //Only the original thread that created a view hierarchy can touch its views.
                                       MainActivity.getInstance().runOnUiThread(() -> {
                                           Network.KarteAufAblagestapelGelegt karteAufAblagestapelGelegt = (Network.KarteAufAblagestapelGelegt) object;
                                           Karte karte = karteAufAblagestapelGelegt.karte;
                                           if (karte instanceof Schatzkarte) {
                                               Spielfeld.getAblageStapelSchatzkartenSlot().karteAblegenWithoutTrigger(karte);
                                           } else {
                                               Spielfeld.getAblageStapelT??rkartenSlot().karteAblegenWithoutTrigger(karte);
                                           }
                                       }
                                       );
                                   }
                                   if(object instanceof Network.KarteZuSpieler)
                                   {
                                       MainActivity.getInstance().runOnUiThread(() -> {
                                           Network.KarteZuSpieler karteZuSpieler = (Network.KarteZuSpieler) object;
                                           Lobby.getPlayer(karteZuSpieler.playerIndex).getInventar().getHandKarten().addKarte(karteZuSpieler.karte);
                                       });
                                   }
                                   if (object instanceof Network.PlayerLevel)
                                   {
                                       Network.PlayerLevel playerLevel = (Network.PlayerLevel)object;
                                       PlayerData playerData = playerLevel.playerData;
                                       Lobby.getPlayer(playerData.getPlayerBoardNumber()).getPlayerLevel().setLevel(playerLevel.level);
                                   }
                               }
                           }
        );
    }

    void n??chsterSpielderIstAnDerReihe(int playerBoardNumber)
    {
        if(Player.getLocalPlayer().getPlayerBoardNumber() == playerBoardNumber)
        {
            //Ich bin dran
            Player.getLocalPlayer().setIstDran(true);
            GamePhase.setPhase(GamePhase.Phase.vorbereitungsPhase);
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

    public static void sendNextPlayerAnDerReihe()
    {
        Network.N??chsterSpielerAnDerReihe n??chsterSpielerAnDerReihe = new Network.N??chsterSpielerAnDerReihe();
        n??chsterSpielerAnDerReihe.playerBoardNumber = Player.getLocalPlayer().getPlayerBoardNumber();

        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(n??chsterSpielerAnDerReihe);
            }
        }.start();
    }

    public static void sendKarteZuSpieler(Karte karte, Player player) {
        Network.KarteZuSpieler karteZuSpieler = new Network.KarteZuSpieler();
        karteZuSpieler.karte = karte;
        karteZuSpieler.playerIndex = player.getPlayerBoardNumber();
        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(karteZuSpieler);
            }
        }.start();
    }

    public static void sendPlayerLevel(Player player)
    {
        Network.PlayerLevel playerLevel = new Network.PlayerLevel();
        playerLevel.playerData = PlayerData.convertToPlayerData(player);
        playerLevel.level = player.getPlayerLevel().getLevel();
        new Thread("thread")
        {
            public void run ()
            {
                getInstance().client.sendTCP(playerLevel);
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
