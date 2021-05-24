package com.example.munchkin;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SpielfeldActivity extends AppCompatActivity {

    private ImageView dice,settings,backbtn,klasse1,rasse1,cardView, cardView2, cardView3, cardView4, midemptycard_bottomleft, treasureCard;
    private ImageView doorcard, backpack;
    private ImageView spieler1,spieler2, spieler3, spieler4;
    private TextView playerCountdowns[] = new TextView[4];
    private List<Karte> drawnCards;
    // Just the collection of all available cards
    private final Inventar inventar = new Inventar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        inventar.setKartenList();
        drawnCards=new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.spielfeldui);

        cardView=findViewById(R.id.cardView);
        cardView2=findViewById(R.id.cardView2);
        cardView3=findViewById(R.id.cardView3);
        cardView4=findViewById(R.id.cardView4);

        midemptycard_bottomleft=findViewById(R.id.midemptycard_bottomleft);


        dice=findViewById(R.id.spielfeldui_dicesicon);
        spieler1=findViewById(R.id.spielfeldui_player1icon);
        spieler2=findViewById(R.id.spielfeldui_player2icon);
        spieler3=findViewById(R.id.spielfeldui_player3icon);
        spieler4=findViewById(R.id.spielfeldui_player4icon);
        settings=findViewById(R.id.spielfeldui_settingsbtn);
        backbtn=findViewById(R.id.spielfeldui_backbutton);
        klasse1=findViewById(R.id.player1_klasseicon);
        rasse1=findViewById(R.id.player1_rasseicon);
        doorcard=findViewById(R.id.spielfeldui_doorcard);
        backpack=findViewById(R.id.spielfeldui_backpackicon);
        treasureCard= findViewById(R.id.spielfeldui_treasurecard);

        treasureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTreasureCard();
            }
        });

        backpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),WinnerPopActivity.class);
                startActivity(intent);
            }
        });

        spieler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        spieler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        spieler3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        spieler4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
                startActivity(intent);
            }
        });

        doorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
                startActivity(intent);
            }
        });

        setCardView(cardView);
        setCardView(cardView2);
        setCardView(cardView3);
        setCardView(cardView4);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAbelegen(cardView,midemptycard_bottomleft);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAbelegen(cardView2,midemptycard_bottomleft);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAbelegen(cardView3,midemptycard_bottomleft);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardAbelegen(cardView4,midemptycard_bottomleft);
            }
        });

        rasse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
                startActivity(intent);
            }
        });

        klasse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),CardPopActivity.class);
                startActivity(intent);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PopActivity.class);
                startActivity(intent);
            }
        });

        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),DiceActivity.class);
                startActivity(i);
            }
        });

       /* playerCountdowns[1]=findViewById(R.id.spielfeldui_player2_countdown);
        playerCountdowns[2]=findViewById(R.id.spielfeldui_player3_countdown);
        playerCountdowns[3]=findViewById(R.id.spielfeldui_player4_countdown);*/
    }

    public void addTreasureCard() {
        int index = getRandomNum(inventar.treasureCardList.size())-1;
        Karte card = inventar.treasureCardList.get(index);
        if(!drawnCards.contains(card)) {
            addCard(card);
        } else {
            addTreasureCard();
        }
    }

    // Add the card to the first free cardview
    public void addCard(Karte card) {
        drawnCards.add(card);
        if(cardView.getVisibility() == View.INVISIBLE)
            setCard(card, cardView);
        else if(cardView2.getVisibility()==View.INVISIBLE)
            setCard(card, cardView2);
        else if(cardView3.getVisibility()==View.INVISIBLE)
            setCard(card, cardView3);
        else if(cardView4.getVisibility()==View.INVISIBLE)
            setCard(card, cardView4);
    }

    private void setCard(Karte card, ImageView cardView) {
        cardView.setImageResource(card.getImage());
        cardView.setVisibility(View.VISIBLE);
    }

    // Returns a random number from 1 to bound (inclusive)
    private int getRandomNum(int bound){
        Random rand= new Random();
        return rand.nextInt(bound)+1;
    }

    public void setCardView(ImageView cardView){
        int index= getRandomNum(50);
        Karte card = inventar.getKartenList().get(index);
        if(!drawnCards.contains(card)){
            cardView.setImageResource(card.getImage());
            drawnCards.add(card);
            cardView.setVisibility(View.VISIBLE);
        }
        else
            setCardView(cardView);
    }

    public void cardHeben(){
        if(cardView.getVisibility() == View.INVISIBLE)
            setCardView(cardView);
        else if(cardView2.getVisibility()==View.INVISIBLE)
            setCardView(cardView2);
        else if(cardView3.getVisibility()==View.INVISIBLE)
            setCardView(cardView3);
        else if(cardView4.getVisibility()==View.INVISIBLE)
            setCardView(cardView4);
    }

    public void cardAbelegen(ImageView card, ImageView field){
        field.setVisibility(View.VISIBLE);
        field.setImageDrawable(card.getDrawable());
        card.setVisibility(View.INVISIBLE);
    }
}
