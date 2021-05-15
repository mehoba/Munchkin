package com.example.munchkin;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity implements SensorEventListener {

    private ImageView diceImage;
    private int prevNum;
    private static final float SHAKE_THRESHOLD = 3.25f;
    private static final int MIN_TIME_BETWEEN_SHAKES = 1000;
    private long mLastShakeTime;
    private SensorManager mSensorMgr;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice);

        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        diceImage=findViewById(R.id.diceImage);




        mSensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor acceloremeter = mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(acceloremeter!= null){
            mSensorMgr.registerListener(this, acceloremeter,SensorManager.SENSOR_DELAY_NORMAL);
        }


           diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int diceNum = getRandomNumber();
                while (diceNum==prevNum){
                    diceNum=getRandomNumber();
                }
                 prevNum = diceNum;
                setDicePicture(diceNum);
                System.out.println(diceNum);
            }
        });

    }

    public void setDicePicture(int diceNum){

        switch (diceNum){
            case 1:
              diceImage.setImageResource(R.drawable.diceone);
              break;
            case 2:
                diceImage.setImageResource(R.drawable.dicetwo);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.dicethree);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.dicefour);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.dicefive);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.dicesix);
                break;

        }
    }


    public int getRandomNumber(){
        Random rand= new Random();
        return rand.nextInt(6)+1;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            long curTime = System.currentTimeMillis();
            if((curTime -mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES){
                float x= event.values[0];
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
    }}

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

