package com.example.munchkin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    static TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtText = findViewById(R.id.txtText);

        try {
            new GameServer();
        } catch (IOException e) {
            e.printStackTrace();
        }


            new GameClient();



    }

    public static void SetText(String text)
    {
        txtText.setText(text);
    }
    public static void AddText(String text)
    {
        txtText.setText(txtText.getText() + " " + text);
    }
}