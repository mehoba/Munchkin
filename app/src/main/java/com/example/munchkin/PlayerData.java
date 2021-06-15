package com.example.munchkin;

//Damit nicht immer der ganze Player über das Networkig geschickt werden muss. Erspart viele fehler und Daten
public class PlayerData
{
    protected String name;
    protected int connectionId;
    protected int playerBoardNumber;//Aufsteigend von 0 - 3. Bestimmt Platz am Board
    protected Boolean istDran;

    //Für Networking
    public PlayerData()
    {

    }

    public PlayerData(Player player)
    {
        name = player.name;
        connectionId = player.connectionId;
        playerBoardNumber = player.playerBoardNumber;
        istDran = player.istDran;
    }

    public static PlayerData convertToPlayerData(Player player)
    {
        PlayerData playerData = null;
        if(player != null)
            playerData = new PlayerData(player);
        return playerData;
    }

    public static PlayerData[] converToPlayerData(Player[] players)
    {
        PlayerData[] playerDataArr = new PlayerData[players.length];

        for(int i = 0; i < players.length; i++)
        {
            playerDataArr[i] = convertToPlayerData(players[i]);
        }

        return playerDataArr;
    }

    public int getPlayerBoardNumber() {
        return playerBoardNumber;
    }

    public void setPlayerBoardNumber(int playerBoardNumber) {
        this.playerBoardNumber = playerBoardNumber;
    }

    public int getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIstDran() {
        return istDran;
    }

    public void setIstDran(Boolean istDran) {
        this.istDran = istDran;
        //Todo lock or unlock player, Buttons unlocken(if locked) etc...
    }
}
