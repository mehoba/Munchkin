package com.example.munchkin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Level;
import com.example.munchkin.Player;
import com.example.munchkin.R;

public class PlayerPopActivity extends AppCompatActivity {

    private TextView txtPlayerstufepopup, txtPlayerName;
    private ImageView imgSkiptimebtn, imgPlayerpicture;
    private SpielfeldActivity sourceActivity;

    private TextView txtPlayerCountdown;
    private CountDownTimer timer;
    private static final int COUNTDOWN_TIME = 120; // Time in seconds

    private static Player player;

    public static void show(Player player)
    {
        PlayerPopActivity.player = player;
        Intent intent=new Intent(SpielfeldActivity.getInstance().getApplicationContext(),PlayerPopActivity.class);
        SpielfeldActivity.getInstance().startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playerinfo_popupview);
        txtPlayerstufepopup = findViewById(R.id.playerpopup_stufetext);
        imgPlayerpicture = findViewById(R.id.player1popup_picture);
        txtPlayerName = findViewById(R.id.playerpopup_name);

        txtPlayerstufepopup.setText("Level: " + player.getPlayerLevel().getLevel());
        txtPlayerName.setText(player.getName());

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int)(height*0.85));

        txtPlayerCountdown = findViewById(R.id.playerpopup_player1_countdown);


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
                txtPlayerCountdown.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                // Reset countdown display
                txtPlayerCountdown.setText("");

                // Switch to next player
                //Todo

                // Restart timer
                this.start();
            }
        }.start();
    }
}
