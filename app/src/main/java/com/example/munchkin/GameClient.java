//package com.example.munchkin;
//
//import com.esotericsoftware.kryonet.Client;
//import com.esotericsoftware.kryonet.Connection;
//import com.esotericsoftware.kryonet.Listener;
//
//import java.io.IOException;
//
//
//public class GameClient
//{
//    Client client;
//    public  GameClient() {
//        client   = new Client();
//        client.start();
//
//        Network.register(client);
//
//        client.addListener(new Listener()
//                           {
//                               @Override
//                               public void connected(Connection connection)
//                               {
//                                    MainActivity.AddText("Connected");
//                               }
//
//                               @Override
//                               public void disconnected(Connection connection)
//                               {
//                                   //MainActivity.SetText("disconnected");
//                               }
//
//                               @Override
//                               public void received(Connection connection, Object object)
//                               {
//                                   if (object instanceof Network.TestClass)
//                                   {
//                                       Network.TestClass test = (Network.TestClass)object;
//                                       MainActivity.AddText(test.text);
//                                   }
//                               }
//                           }
//
//        );
//
//        new Thread("Connect") {
//            public void run () {
//                try {
//                    client.connect(5000, "127.0.0.1", Network.port);
//                    // Server communication after connection can go here, or in Listener#connected().
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    System.exit(1);
//                }
//            }
//        }.start();
//    }
//}
