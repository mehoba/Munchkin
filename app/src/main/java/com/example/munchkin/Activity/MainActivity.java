package com.example.munchkin.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Networking.Network;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.R;


public class MainActivity extends AppCompatActivity
{
    public static GameClient gameClient;
    static MainActivity instance;

    public TextView playername, playernameinvalid, txtServerIpAddress;

    private ImageView spielenbutton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playername_view);

        instance = this;

        spielenbutton = findViewById(R.id.playername_startbutton);
        playername = findViewById(R.id.playernameinput);
        playernameinvalid = findViewById(R.id.playername_error);
        txtServerIpAddress = findViewById(R.id.txtServerIPAddress);
        txtServerIpAddress.setText(Network.ipAdressServer);

        spielenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spielen(view);
            }
        });

        new Lobby();

        //Start Client
        //--------------------------------
        //Comment this line if you want to debug without Server
        //gameClient = new GameClient();
        //--------------------------------


    }

    private void spielen(View view)
    {
        playernameinvalid.setVisibility(View.INVISIBLE);
        if(gameClient == null)//Zum debuggen, falls kein Server zur verfügung steht
        {
            successfullyConnectedToServer();
            return;
        }

        if (checkIfTextViewEmptyOrNull(playernameinvalid) || checkIfTextViewEmptyOrNull(txtServerIpAddress))
            playernameinvalid.setVisibility(View.VISIBLE);
        else
            gameClient.connectToServer(txtServerIpAddress.getText().toString(), playername.getText().toString());
    }

    public void successfullyConnectedToServer()
    {
        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        startActivity(intent);
        finish();
    }

    boolean checkIfTextViewEmptyOrNull(TextView textView)
    {
        if (textView.getText().toString().equals("") || textView == null)
            return true;
        return false;
    }

    public static MainActivity getInstance()
    {
        return instance;
    }

}