package com.example.munchkin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    private ImageView menuspielen,menuexit,menueinstellungen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuspielen=findViewById(R.id.menuspielenbutton);
        menuexit=findViewById(R.id.menuexitbutton);
        menueinstellungen=findViewById(R.id.menusettingsbutton);

        menueinstellungen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });

        menuspielen.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SpielfeldActivity.class);
                startActivity(i);
            }
        });

        menuexit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(1);
            }
        });
    }
}
