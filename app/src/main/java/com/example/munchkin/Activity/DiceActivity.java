package com.example.munchkin.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.munchkin.Kampf;
import com.example.munchkin.R;
import com.example.munchkin.Spielfeld;

import java.util.Random;

public class DiceActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView imgDice;
    private int prevNum;
    private static final float SHAKE_THRESHOLD = 3.25f;
    private static final int MIN_TIME_BETWEEN_SHAKES = 1000;
    private long mLastShakeTime;
    private SensorManager mSensorMgr;
    private int diceNum;
    private static Kampf kampf;
    private boolean schonGewürfelt=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        schonGewürfelt = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));

        imgDice = findViewById(R.id.diceImage);


        mSensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor acceloremeter = mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (acceloremeter != null) {
            mSensorMgr.registerListener(this, acceloremeter, SensorManager.SENSOR_DELAY_NORMAL);
        }


        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!schonGewürfelt){
                    diceNum = getRandomNumber();
                    while (diceNum == prevNum) {
                        diceNum = getRandomNumber();
                    }
                    prevNum = diceNum;
                    setDicePicture(diceNum);
                    System.out.println(diceNum);
                    warte1Sekunde();
                    schonGewürfelt = true;
                }
            }
        });

    }

    private void warte1Sekunde() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                kampf.weglaufen(diceNum);
                finish();
            }
        };
        Handler h = new Handler();
        h.postDelayed(r, 1000);
    }

    public void setDicePicture(int diceNum) {

        switch (diceNum) {
            case 1:
                imgDice.setImageResource(R.drawable.diceone);
                break;
            case 2:
                imgDice.setImageResource(R.drawable.dicetwo);
                break;
            case 3:
                imgDice.setImageResource(R.drawable.dicethree);
                break;
            case 4:
                imgDice.setImageResource(R.drawable.dicefour);
                break;
            case 5:
                imgDice.setImageResource(R.drawable.dicefive);
                break;
            case 6:
                imgDice.setImageResource(R.drawable.dicesix);
                break;

        }
    }


    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                double acceleration = Math.sqrt(Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;

                if (acceleration > SHAKE_THRESHOLD) {
                    mLastShakeTime = curTime;
                    setDicePicture(getRandomNumber());

                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public static void show(Kampf kampf) {
        DiceActivity.kampf = kampf;

        Intent i = new Intent(SpielfeldActivity.getInstance().getApplicationContext(), DiceActivity.class);
        SpielfeldActivity.getInstance().startActivity(i);
    }
}

