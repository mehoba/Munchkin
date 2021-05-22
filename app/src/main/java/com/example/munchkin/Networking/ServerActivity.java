package com.example.munchkin.Networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.munchkin.GameServer;
import com.example.munchkin.R;

import java.io.IOException;

public class ServerActivity extends AppCompatActivity {

    static TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server2);
        //txtText = findViewById(R.id.txtText);

        try
        {
            new GameServer();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void SetText(String text)
    {

    }
    public static void AddText(String text)
    {
        //txtText.setText(txtText.getText() + " " + text);
    }
}