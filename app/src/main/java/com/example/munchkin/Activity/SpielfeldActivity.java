package com.example.munchkin.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.Player;
import com.example.munchkin.R;
import com.example.munchkin.Spielfeld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class SpielfeldActivity extends AppCompatActivity {
    private static SpielfeldActivity instance;

    public ImageView imgDice, imgSettings, imgBackbtn, imgKlasse1, imgRasse1, imgCardView, imgCardView2, imgCardView3, imgCardView4,imgMidemptycard_bottomleft, imgSchatzkarte, imgdoorcard;
    private ImageView imgDoorcard, imgBackpack;
    private ImageView imgSpieler1, imgSpieler2, imgSpieler3, imgSpieler4;
    private TextView[] txtPlayerCountdowns = new TextView[4];
    private List<Karte> drawnCards;
    // Just the collection of all available cards
    //private final Inventar inventar = new Inventar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        //inventar.setKartenList();
        drawnCards=new ArrayList<>();



        setContentView(R.layout.spielfeldui);

        imgCardView =findViewById(R.id.cardView);
        imgCardView2 =findViewById(R.id.cardView2);
        imgCardView3 =findViewById(R.id.cardView3);
        imgCardView4 =findViewById(R.id.cardView4);

        imgMidemptycard_bottomleft =findViewById(R.id.midemptycard_bottomleft);


        imgDice =findViewById(R.id.spielfeldui_dicesicon);
        imgSpieler1 =findViewById(R.id.spielfeldui_player1icon);
        imgSpieler2 =findViewById(R.id.spielfeldui_player2icon);
        imgSpieler3 =findViewById(R.id.spielfeldui_player3icon);
        imgSpieler4 =findViewById(R.id.spielfeldui_player4icon);
        imgSettings =findViewById(R.id.spielfeldui_settingsbtn);
        imgBackbtn =findViewById(R.id.spielfeldui_backbutton);
        imgKlasse1 =findViewById(R.id.player1_klasseicon);
        imgRasse1 =findViewById(R.id.player1_rasseicon);
        imgDoorcard =findViewById(R.id.spielfeldui_doorcard);
        imgBackpack =findViewById(R.id.spielfeldui_backpackicon);
        imgSchatzkarte = findViewById(R.id.spielfeldui_treasurecard);
        imgdoorcard = findViewById(R.id.spielfeldui_doorcard);



//        imgTreasureCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addTreasureCard();
//            }
//        });

        imgBackpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),WinnerPopActivity.class);
                startActivity(intent);
            }
        });

        imgSpieler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        imgSpieler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        imgSpieler3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        imgSpieler4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        imgDoorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
                startActivity(intent);
            }
        });

//        setCardView(imgCardView);
//        setCardView(imgCardView2);
//        setCardView(imgCardView3);
//        setCardView(imgCardView4);
//
//        imgCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardAbelegen(imgCardView, imgMidemptycard_bottomleft);
//            }
//        });
//        imgCardView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardAbelegen(imgCardView2, imgMidemptycard_bottomleft);
//            }
//        });
//        imgCardView3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardAbelegen(imgCardView3, imgMidemptycard_bottomleft);
//            }
//        });
//        imgCardView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardAbelegen(imgCardView4, imgMidemptycard_bottomleft);
//            }
//        });

        imgRasse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
                startActivity(intent);
            }
        });

        imgKlasse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
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

//    public void addTreasureCard() {
//        int index = getRandomNum(inventar.treasureCardList.size())-1;
//        Karte card = inventar.treasureCardList.get(index);
//        if(!drawnCards.contains(card)) {
//            addCard(card);
//        } else {
//            addTreasureCard();
//        }
//    }

//    // Add the card to the first free cardview
//    public void addCard(Karte card) {
//        drawnCards.add(card);
//        if(imgCardView.getVisibility() == View.INVISIBLE)
//            setCard(card, imgCardView);
//        else if(imgCardView2.getVisibility()==View.INVISIBLE)
//            setCard(card, imgCardView2);
//        else if(imgCardView3.getVisibility()==View.INVISIBLE)
//            setCard(card, imgCardView3);
//        else if(imgCardView4.getVisibility()==View.INVISIBLE)
//            setCard(card, imgCardView4);
//    }

    private void setCard(Karte card, ImageView imgCardView) {
        imgCardView.setImageResource(card.getImage());
        imgCardView.setVisibility(View.VISIBLE);
    }

    // Returns a random number from 1 to bound (inclusive)
    private int getRandomNum(int bound){
        Random rand= new Random();
        return rand.nextInt(bound)+1;
    }

//    public void setCardView(ImageView imgCardView){
//        int index= getRandomNum(50);
//        Karte card = inventar.getKartenList().get(index);
//        if(!drawnCards.contains(card)){
//            imgCardView.setImageResource(card.getImage());
//            drawnCards.add(card);
//            imgCardView.setVisibility(View.VISIBLE);
//        }
//        else
//            setCardView(imgCardView);
//    }

//    public void cardHeben(){
//        if(imgCardView.getVisibility() == View.INVISIBLE)
//            setCardView(imgCardView);
//        else if(imgCardView2.getVisibility()==View.INVISIBLE)
//            setCardView(imgCardView2);
//        else if(imgCardView3.getVisibility()==View.INVISIBLE)
//            setCardView(imgCardView3);
//        else if(imgCardView4.getVisibility()==View.INVISIBLE)
//            setCardView(imgCardView4);
//    }

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
