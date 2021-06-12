package com.example.munchkin.Networking;
import android.util.Log;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerData;
import com.example.munchkin.PlayerSideUI;

import java.util.LinkedList;

//Stores all the Player for the Server
public class Lobby
{
    private static Lobby instance;

    Player[] players = new Player[4];

    public Lobby()
    {
        if(instance != null)
            Log.e("Lobby","second Lobby created");

        instance = this;

        //safe is safe
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
    public static void addPlayer(PlayerData playerData)
    {
        Player player = new Player(playerData);

        Player[] players = instance.players;
        players[playerData.getPlayerBoardNumber()] = player;

        addPlayerSideUiToPlayer(player);
    }

    static void addPlayerSideUiToPlayer(Player player)
    {
        if(SpielfeldActivity.getInstance() != null)
        {
            player.setPlayerSideUI();
            player.writeNameToTextView();
        }
    }

    public static void syncLobby(Network.SyncLobbyForNewPlayer syncLobbyForNewPlayer)
    {
        PlayerData[] playerDataArr = syncLobbyForNewPlayer.playerDataArr;
        int localPlayerBoardNumber = syncLobbyForNewPlayer.localPlayerIndex;

        for(int i = 0; i < playerDataArr.length; i++)
        {
            if(playerDataArr[i] != null)
            {
                addPlayer(playerDataArr[i]);
            }
        }
        Player.setLocalPlayer(Lobby.getPlayer(localPlayerBoardNumber));
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

    //Returns the next Player which is not null. If only one player is in the lobby, return the same player
    public static Player getNextPlayer(Player player)
    {
        Player[] players = instance.players;

        for(int i = 1; i < players.length; i++)
        {
            int nextPlayerIndex = (i + player.getPlayerBoardNumber()) % players.length;
            if(players[nextPlayerIndex] != null)
            {
                return players[nextPlayerIndex];
            }
        }

        //Solo game
        return player;
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
