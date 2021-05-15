package com.example.munchkin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerPopActivity extends AppCompatActivity {

    private ImageView skiptimebtn;
    private int activePlayer = 1;

    private TextView playerCountdowns[] = new TextView[4];
    private CountDownTimer timer;
    private int COUNTDOWN_TIME = 120; // Time in seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerinfo_popupview);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        playerCountdowns[0]=findViewById(R.id.spielfeldui_player1_countdown);
        playerCountdowns[1]=findViewById(R.id.spielfeldui_player2_countdown);
        playerCountdowns[2]=findViewById(R.id.spielfeldui_player3_countdown);
        playerCountdowns[3]=findViewById(R.id.spielfeldui_player4_countdown);

        skiptimebtn=findViewById(R.id.playerpop_skiptimebtn);

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
