package com.example.munchkin.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Player;
import com.example.munchkin.PlayerSideUI;
import com.example.munchkin.R;
import com.example.munchkin.Spielfeld;

import java.util.LinkedList;
import java.util.Random;


public class SpielfeldActivity extends AppCompatActivity {
    private static SpielfeldActivity instance;

    public ImageView imgDice, imgSettings, imgBackbtn, imgMonsterKartenSlot, imgAusgespielteKartenSlot, imgSchatzkarte, imgdoorcard, ablageStapelTürkarten, ablageStapelSchatzkarten;
    public ImageView imgButtonKämpfen, imgButtonWeglaufen;
    private ImageView imgDoorcard, imgBackpack;

//    public ImageView imgSpieler1Icon, imgSpieler2Icon, imgSpieler3Icon, imgSpieler4Icon;
//    public TextView txtSpieler1Name, txtSpieler2Name, txtSpieler3Name, txtSpieler4Name;
//    public ImageView imgSpieler1Klasse, imgSpieler2Klasse, imgSpieler3Klasse, imgSpieler4Klasse;
//    public ImageView imgSpieler1Rasse, imgSpieler2Rasse, imgSpieler3Rasse, imgSpieler4Rasse;

    private TextView[] txtPlayerCountdowns = new TextView[4];
    public LinearLayout handcardLayout;

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
        imgBackpack =findViewById(R.id.spielfeldui_backpackicon);
        imgSchatzkarte = findViewById(R.id.spielfeldui_treasurecard);
        imgdoorcard = findViewById(R.id.spielfeldui_doorcard);

        ablageStapelTürkarten = findViewById(R.id.imgAblageStapelTürkarten);
        ablageStapelSchatzkarten = findViewById(R.id.imgAblageStapelSchatzkarten);
        //Für Kampf
        imgButtonKämpfen = findViewById(R.id.imgButtonKämpfen);
        imgButtonWeglaufen= findViewById(R.id.imgButtonWeglaufen);


        imgBackpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),WinnerPopActivity.class);
                startActivity(intent);
            }
        });

        imgDoorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), CardPopActivity_handkarten.class);
                startActivity(intent);
            }
        });

        imgBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }
        });

        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PopActivity.class);
                startActivity(intent);
            }
        });

        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DiceActivity.class);
                startActivity(i);
            }
        });

       /* playerCountdowns[1]=findViewById(R.id.spielfeldui_player2_countdown);
        playerCountdowns[2]=findViewById(R.id.spielfeldui_player3_countdown);
        playerCountdowns[3]=findViewById(R.id.spielfeldui_player4_countdown);*/

        new Spielfeld().initializeUiConnection();
        Player.getLocalPlayer().initializeUIConnection();

        setPlayerNames();
    }

    void createPlayerSideUIs()
    {
        createPlayerSideBottom();
        createPlayerSideRight();
        createPlayerSideLeft();
        createPlayerSideTop();
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

    private void setCard(Karte card, ImageView imgCardView) {
        imgCardView.setImageResource(card.getImage());
        imgCardView.setVisibility(View.VISIBLE);
    }

    // Returns a random number from 1 to bound (inclusive)
    private int getRandomNum(int bound){
        Random rand= new Random();
        return rand.nextInt(bound)+1;
    }

    public void cardAbelegen(ImageView imgCard, ImageView imgField){
        imgField.setVisibility(View.VISIBLE);
        imgField.setImageDrawable(imgCard.getDrawable());
        imgCard.setVisibility(View.INVISIBLE);
    }

    public void setPlayerNames()
    {
        if(Lobby.getInstance() == null)
            return ;

        TextView[] txtPlayerNames = new TextView[4];
        txtPlayerNames[0] = findViewById(R.id.spielfeldui_player1name);
        txtPlayerNames[1] = findViewById(R.id.spielfeldui_player2name);
        txtPlayerNames[2] = findViewById(R.id.spielfeldui_player3name);
        txtPlayerNames[3] = findViewById(R.id.spielfeldui_player4name);

        LinkedList<String> playerNames = Lobby.getPlayerNames();

        for(int i = 0; i < playerNames.size(); i++)
        {
            if(txtPlayerNames[i] != null)
                txtPlayerNames[i].setText(playerNames.get(i));
        }
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
