package com.example.munchkin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private ImageView imgMenuSpielen, imgMenuExit, imgMenuEinstellungen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMenuSpielen = findViewById(R.id.menuspielenbutton);
        imgMenuExit = findViewById(R.id.menuexitbutton);
        imgMenuEinstellungen = findViewById(R.id.menusettingsbutton);

        imgMenuEinstellungen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });

        imgMenuSpielen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SpielfeldActivity.class);
                startActivity(i);
            }
        });

        imgMenuExit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(1);
            }
        });
    }
}
