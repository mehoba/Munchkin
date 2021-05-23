package com.example.munchkin.Networking;
import com.example.munchkin.Player;

import java.util.LinkedList;

//Stores all the Player for the Server
public class Lobby
{
    Player[] players = new Player[4];

    //Return true if successfully added
    public boolean addPlayer(Player player)
    {
        for(int i = 0; i < players.length; i++)
        {
            if(players[i] == null)
            {
                players[i] = player;
                players[i].playerBoardNumber = i;
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
            if(players[i] != null && players[i].connectionId == connectionId)
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
                playerNamesList.add(players[i].name);
        }

        return playerNamesList;
    }
}
