package com.example.munchkin;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EquipActivity extends AppCompatActivity {

    private CountDownTimer timer;
    private final int EQUIP_TIME = 120; // Time in seconds
    private Button skipButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equip);

        final TextView countdownText = findViewById(R.id.equip_countdown);

        timer = new CountDownTimer(EQUIP_TIME*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countdownText.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), DiceActivity.class);
                startActivity(intent);
            }
        }.start();

        skipButton = findViewById(R.id.equip_skip);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                timer.onFinish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
