package com.example.munchkin.Networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.munchkin.R;

import java.io.IOException;

public class ServerActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server2);

        try
        {
            new Lobby();
            new GameServer();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}