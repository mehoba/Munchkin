//package com.example.munchkin;
//
//import com.esotericsoftware.kryonet.Connection;
//import com.esotericsoftware.kryonet.Listener;
//import com.esotericsoftware.kryonet.Server;
//
//import java.io.IOException;
//import java.util.List;
//
//public class GameServer
//{
//    Server server;
//
//    public  GameServer() throws IOException
//    {
//        server = new Server();
//
//        Network.register(server);
//        server.addListener(new Listener(){
//            @Override
//            public void received(Connection connection, Object object)
//            {
//
//            }
//
//            @Override
//            public void connected(Connection connection)
//            {
//                Network.TestClass test = new Network.TestClass();
//                test.text = "Dies ist ein Serialisiertes Objekt";
//
//                server.sendToTCP(connection.getID(), test);
//            }
//        });
//
//
//
//        server.bind(Network.port);
//        server.start();
//    }
//}
