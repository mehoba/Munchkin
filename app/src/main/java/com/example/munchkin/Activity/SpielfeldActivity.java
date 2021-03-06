package com.example.munchkin.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
import com.example.munchkin.Karte.SchatzkartenStapel;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerSideUI;
import com.example.munchkin.R;
import com.example.munchkin.Spielfeld;


public class SpielfeldActivity extends AppCompatActivity {
    private static SpielfeldActivity instance;

    public ImageView imgDice, imgSettings, imgBackbtn, imgMonsterKartenSlot, imgAusgespielteKartenSlot, imgSchatzkarte, imgdoorcard, ablageStapelTürkarten, ablageStapelSchatzkarten;
    public ImageView imgButtonKämpfen, imgButtonWeglaufen;
    private ImageView imgDoorcard, imgBackpack;

    private TextView[] txtPlayerCountdowns = new TextView[4];
    public LinearLayout handcardLayout;
    public TextView txtZiehenSchatzkartenStapel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        setContentView(R.layout.spielfeldui);
        createPlayerSideUIs();

        handcardLayout = findViewById(R.id.spielfeldui_handcard_layout);

        imgMonsterKartenSlot =findViewById(R.id.monsterKartenSlot);
        imgAusgespielteKartenSlot =findViewById(R.id.ausgespielteKartenSlot);

        imgDice =findViewById(R.id.spielfeldui_dicesicon);
        imgSettings =findViewById(R.id.spielfeldui_settingsbtn);
        imgBackbtn =findViewById(R.id.spielfeldui_backbutton);
        imgDoorcard =findViewById(R.id.spielfeldui_doorcard);
        imgSchatzkarte = findViewById(R.id.spielfeldui_treasurecard);
        imgdoorcard = findViewById(R.id.spielfeldui_doorcard);

        ablageStapelTürkarten = findViewById(R.id.imgAblageStapelTürkarten);
        ablageStapelSchatzkarten = findViewById(R.id.imgAblageStapelSchatzkarten);
        //Für Kampf
        imgButtonKämpfen = findViewById(R.id.imgButtonKämpfen);
        imgButtonWeglaufen= findViewById(R.id.imgButtonWeglaufen);

        txtZiehenSchatzkartenStapel = findViewById(R.id.txtZiehenSchatzkartenStapel);


        imgSchatzkarte.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TreasureCardActivity.class);
            startActivity(intent);
        });

        imgDoorcard.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(), CardPopActivity_handkarten.class);
            startActivity(intent);
        });

        imgBackbtn.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),MainMenuActivity.class);
            startActivity(intent);
        });

        imgSettings.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),PopActivity.class);
            startActivity(intent);
        });

        imgDice.setOnClickListener(view -> {
            Intent i=new Intent(getApplicationContext(),DiceActivity.class);
            startActivity(i);
        });

        imgMonsterKartenSlot.setOnClickListener(view -> {
            if (Spielfeld.getMonsterKartenSlot().getKarte() != null){
                MonsterCardActivity.show((Monsterkarte) Spielfeld.getMonsterKartenSlot().getKarte());
            }
        });

       /* playerCountdowns[1]=findViewById(R.id.spielfeldui_player2_countdown);
        playerCountdowns[2]=findViewById(R.id.spielfeldui_player3_countdown);
        playerCountdowns[3]=findViewById(R.id.spielfeldui_player4_countdown);*/

        new Spielfeld().initializeUiConnection();
        Player.getLocalPlayer().initializeUIConnection();

        //Da anfangs nur 4 Schatzkarten gezogen werden dürfen, dann wird dies je nach besiegtem Monster gesetzt
        SchatzkartenStapel.setAnzahlErlaubtesZiehen(4);

//        PlayerSideUI.hideAllSidesExceptLocal();
    }

    void createPlayerSideUIs()
    {
        createPlayerSideBottom();
        createPlayerSideRight();
        createPlayerSideLeft();
        createPlayerSideTop();

        setPlayerSideUI_InPlayers();
    }

    void setPlayerSideUI_InPlayers()
    {
        Player[] players = Lobby.getPlayers();

        for(int i = 0; i < players.length; i++)
        {
            if(players[i] != null)
            {
                players[i].setPlayerSideUI();
            }
        }
    }

    void createPlayerSideBottom()
    {
        ImageView imgSpielerIcon = findViewById(R.id.spielfeldui_player1icon);
        TextView txtSpielerName = findViewById(R.id.spielfeldui_player1name);
        ImageView imgSpielerKlasse = findViewById(R.id.player1_klasseicon);
        ImageView imgSpielerRasse = findViewById(R.id.player1_rasseicon);

        new PlayerSideUI(imgSpielerIcon, imgSpielerKlasse, imgSpielerRasse, txtSpielerName, 0);
    }
    void createPlayerSideRight()
    {
        ImageView imgSpielerIcon = findViewById(R.id.spielfeldui_player2icon);
        TextView txtSpielerName = findViewById(R.id.spielfeldui_player2name);
        ImageView imgSpielerKlasse = findViewById(R.id.player2_klasseicon);
        ImageView imgSpielerRasse = findViewById(R.id.player2_rasseicon);

        new PlayerSideUI(imgSpielerIcon, imgSpielerKlasse, imgSpielerRasse, txtSpielerName, 1);
    }
    void createPlayerSideLeft()
    {
        ImageView imgSpielerIcon = findViewById(R.id.spielfeldui_player3icon);
        TextView txtSpielerName = findViewById(R.id.spielfeldui_player3name);
        ImageView imgSpielerKlasse = findViewById(R.id.player3_klasseicon);
        ImageView imgSpielerRasse = findViewById(R.id.player3_rasseicon);

        new PlayerSideUI(imgSpielerIcon, imgSpielerKlasse, imgSpielerRasse, txtSpielerName, 2);
    }
    void createPlayerSideTop()
    {
        ImageView imgSpielerIcon = findViewById(R.id.spielfeldui_player4icon);
        TextView txtSpielerName = findViewById(R.id.spielfeldui_player4name);
        ImageView imgSpielerKlasse = findViewById(R.id.player4_klasseicon);
        ImageView imgSpielerRasse = findViewById(R.id.player4_rasseicon);

        new PlayerSideUI(imgSpielerIcon, imgSpielerKlasse, imgSpielerRasse, txtSpielerName, 3);
    }


    public static SpielfeldActivity getInstance()
    {
        return instance;
    }

    public void notifyAboutWin() {
        Intent i = new Intent(getApplicationContext(), WinnerPopActivity.class);
        startActivity(i);
    }
}
