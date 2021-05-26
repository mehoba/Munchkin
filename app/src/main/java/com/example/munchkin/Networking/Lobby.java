package com.example.munchkin.Networking;
import com.example.munchkin.Player;

import java.util.LinkedList;

//Stores all the Player for the Server
public class Lobby
{
    private static Lobby instance = null;

    Player[] players = new Player[4];

    //ToDo localPlayer
    Player localPlayer;

    public Lobby()
    {
        instance = this;
    }

    //Return true if successfully added
    public boolean addPlayer(Player player)
    {
        for(int i = 0; i < players.length; i++)
        {
            if(players[i] == null)
            {
                players[i] = player;
                players[i].setPlayerBoardNumber(i);
                return true;
            }
        }
        return false;
    }

    //Return true if successfully removed
    public boolean removePlayer(int connectionId)
    {
        for(int i = 0; i < players.length; i++)
        {
            if(players[i] != null && players[i].getConnectionId() == connectionId)
            {
                players[i] = null;
                return true;
            }
        }

        return false;
    }

    public LinkedList<String> getPlayerNames()
    {
        LinkedList<String> playerNamesList = new LinkedList<>();

        for(int i = 0; i < players.length; i++)
        {
            if(players[i] != null)
                playerNamesList.add(players[i].getName());
        }

        return playerNamesList;
    }

    public static Lobby getInstance()
    {
        return instance;
    }

    public static void setInstance(Lobby lobby)
    {
        instance = lobby;
    }
}
