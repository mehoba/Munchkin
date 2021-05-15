package com.example.munchkin;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SpielfeldActivity extends AppCompatActivity {


    private ImageView dice,settings,backbtn,klasse1,rasse1,doorcard, backpack;
    private ImageView spieler1,spieler2, spieler3, spieler4;

    private int activePlayer = 1;

    private TextView playerCountdowns[] = new TextView[4];
    private CountDownTimer timer;
    private final int COUNTDOWN_TIME = 120; // Time in seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spielfeldui);

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

        playerCountdowns[0]=findViewById(R.id.spielfeldui_player1_countdown);
        playerCountdowns[1]=findViewById(R.id.spielfeldui_player2_countdown);
        playerCountdowns[2]=findViewById(R.id.spielfeldui_player3_countdown);
        playerCountdowns[3]=findViewById(R.id.spielfeldui_player4_countdown);

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

        initTimer();
    }

    private void initTimer() {
        timer = new CountDownTimer(COUNTDOWN_TIME*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                playerCountdowns[activePlayer-1].setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                // Reset countdown display
                playerCountdowns[activePlayer-1].setText("");

                // Switch to next player
                activePlayer = (activePlayer % 4) + 1;

                // Restart timer
                this.start();
            }
        }.start();
    }
}
