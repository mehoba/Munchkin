package com.example.munchkin;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class SpielfeldActivity extends AppCompatActivity {

    private ImageView dice,spieler1,settings,backbtn,klasse1,rasse1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spielfeldui);

        dice=findViewById(R.id.spielfeldui_dicesicon);
        spieler1=findViewById(R.id.spielfeldui_player1icon);
        settings=findViewById(R.id.spielfeldui_settingsbtn);
        backbtn=findViewById(R.id.spielfeldui_backbutton);
        klasse1=findViewById(R.id.player1_klasseicon);
        rasse1=findViewById(R.id.player1_rasseicon);

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
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
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

        spieler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PlayerPopActivity.class);
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
    }

}
