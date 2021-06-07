package com.example.munchkin.Networking;
import android.util.Log;

import com.example.munchkin.Player;
import com.example.munchkin.PlayerData;

import java.util.LinkedList;

//Stores all the Player for the Server
public class Lobby
{
    private static Lobby instance;

    Player[] players = new Player[4];

    //ToDo localPlayer
    Player localPlayer;

    public Lobby()
    {
        if(instance != null)
            Log.e("Lobby","second Lobby created");

        instance = this;

        for(Player player : players)
        {
            player = null;
        }
    }

    //Return index in array if successfully added
    public static int addPlayerAtFreePosition(Player player)
    {
        Player[] players = instance.players;

        for(int i = 0; i < players.length; i++)
        {
            if(players[i] == null)
            {
                players[i] = player;
                players[i].setPlayerBoardNumber(i);
                return i;
            }
        }
        return -1;
    }

    public static boolean addPlayer(Player player, int index)
    {
        Player[] players = instance.players;
        players[index] = player;
        return false;
    }
    public static boolean addPlayer(PlayerData playerData)
    {
        Player player = new Player(playerData);

        Player[] players = instance.players;
        players[playerData.getPlayerBoardNumber()] = player;
        return false;
    }

    //Return true if successfully removed
    public static boolean removePlayer(int connectionId)
    {
        Player[] players = instance.players;

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

    public static LinkedList<String> getPlayerNames()
    {
        Player[] players = instance.players;

        LinkedList<String> playerNamesList = new LinkedList<>();

        for(int i = 0; i < players.length; i++)
        {
            if(players[i] != null)
                playerNamesList.add(players[i].getName());
        }

        return playerNamesList;
    }

    public static void newPlayerJoined(PlayerData newPlayer)
    {
        addPlayer(newPlayer);
    }

    public static Player[] getPlayers()
    {
        return instance.players;
    }

    public static Player getPlayer(int index)
    {
        return instance.players[index];
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
