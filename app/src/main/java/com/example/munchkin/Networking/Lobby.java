package com.example.munchkin.Networking;
import com.example.munchkin.Player;

import java.util.LinkedList;
public class Lobby
{
    LinkedList<Player> players = new LinkedList<>();

    public  void addPlayer(Player player)
    {
        players.add(player);
    }

    public  boolean removePlayer(int connectionId)
    {
        Player playerToRemove = null;

        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).connectionId == connectionId)
            {
                playerToRemove = players.get(i);
            }
        }
        if(playerToRemove != null)
        {
            players.remove(playerToRemove);
            return  true;
        }
        return false;
    }

    public String[] getPlayerNames()
    {
        String[] playerNames = new String[players.size()];

        for(int i = 0; i < players.size(); i++)
        {
            playerNames[i] = players.get(i).name;
        }
        return playerNames;
    }
}
