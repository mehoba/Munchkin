package com.example.munchkin.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.view.View;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.esotericsoftware.kryonet.Server;
import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Networking.GameServer;
import com.example.munchkin.Networking.Network;
import com.example.munchkin.Networking.Lobby;
import com.example.munchkin.R;

import java.io.IOException;


public class MainActivity extends AppCompatActivity
{
    public static GameClient gameClient;
    static MainActivity instance;

    public TextView txtPlayername, txtPlayernameInvalid, txtServerIpAddress;

    private ImageView imgSpielenButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playername_view);

        instance = this;

        imgSpielenButton = findViewById(R.id.playername_startbutton);
        txtPlayername = findViewById(R.id.playernameinput);
        txtPlayernameInvalid = findViewById(R.id.playername_error);
        txtServerIpAddress = findViewById(R.id.txtServerIPAddress);
        txtServerIpAddress.setText(Network.ipAdressServer);

        imgSpielenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spielen(view);
            }
        });

        CheckBox checkBoxStartServer = findViewById(R.id.checkBoxStartServer);
        checkBoxStartServer.setOnClickListener(v -> {
            GameServer.startWithClient = checkBoxStartServer.isChecked();
        });

        new Lobby();
        gameClient = new GameClient();
    }

    private void spielen(View view)
    {
        if(GameServer.startWithClient) {
            try {
                new GameServer();
                Toast.makeText(this, "Server wurde gestartet", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Server konnte nicht gestartet werden", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        txtPlayernameInvalid.setVisibility(View.INVISIBLE);
        if(gameClient == null)//Zum debuggen, falls kein Server zur verfügung steht
        {
            successfullyConnectedToServer();
            return;
        }

        if (checkIfTextViewEmptyOrNull(txtPlayernameInvalid) || checkIfTextViewEmptyOrNull(txtServerIpAddress))
            txtPlayernameInvalid.setVisibility(View.VISIBLE);
        else
            gameClient.connectToServer(txtServerIpAddress.getText().toString(), txtPlayername.getText().toString());
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