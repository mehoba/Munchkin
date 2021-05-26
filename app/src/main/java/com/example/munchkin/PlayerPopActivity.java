package com.example.munchkin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerPopActivity extends AppCompatActivity {

    public Level level;
    private TextView txtPlayerstufepopup;
    private ImageView imgSkiptimebtn, imgPlayerpicture;
    private int activePlayer = 1;
    private SpielfeldActivity sourceActivity;

    private TextView[] txtPlayerCountdowns = new TextView[4];
    private CountDownTimer timer;
    private int COUNTDOWN_TIME = 120; // Time in seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerinfo_popupview);
        txtPlayerstufepopup = findViewById(R.id.playerpopup_stufetext);
        imgPlayerpicture = findViewById(R.id.player1popup_picture);

        level = new Level(sourceActivity);

        txtPlayerstufepopup.setText(Integer.toString(level.getLevel()));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        txtPlayerCountdowns[0] = findViewById(R.id.playerpopup_player1_countdown);


        imgSkiptimebtn = findViewById(R.id.playerpop_skiptimebtn);


        initTimer();

        imgSkiptimebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                timer.cancel();
                timer.onTick(0);
            }
        });
    }


    private void initTimer() {
        timer = new CountDownTimer(COUNTDOWN_TIME*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtPlayerCountdowns[activePlayer-1].setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                // Reset countdown display
                txtPlayerCountdowns[activePlayer-1].setText("");

                // Switch to next player
                activePlayer = (activePlayer % 4) + 1;

                // Restart timer
                this.start();
            }
        }.start();
    }
}
