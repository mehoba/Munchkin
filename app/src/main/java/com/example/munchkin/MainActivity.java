package com.example.munchkin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView spielenbutton;
    public TextView playername, playernameinvalid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playername_view);

        spielenbutton = findViewById(R.id.playername_startbutton);
        playername=findViewById(R.id.playernameinput);
        playernameinvalid=findViewById(R.id.playername_error);

        spielenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spielen(view);
            }
        });


    }

    private void spielen(View view){
        if(playername.getText().toString().equals("")||playername==null){

            playernameinvalid.setVisibility(View.VISIBLE);

        }else{

            Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
            startActivity(intent);

        }
    }

}