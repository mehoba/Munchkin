package com.example.munchkin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DiceActivity extends AppCompatActivity {

    private ImageView diceImage;
    private int prevNum;



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
}

