package com.example.munchkin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private Button exitBtn, diceBtn;

    private ImageView menuspielen,menuexit,menueinstellungen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuspielen=findViewById(R.id.menuspielenbutton);
        menuexit=findViewById(R.id.menuexitbutton);
        menueinstellungen=findViewById(R.id.menusettingsbutton);

        menueinstellungen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });

        menuspielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpielfeldActivity.class);
                startActivity(intent);
            }
        });

        menuexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });
    }

}