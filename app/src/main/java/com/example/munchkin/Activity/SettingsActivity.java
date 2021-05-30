package com.example.munchkin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.R;

public class SettingsActivity extends AppCompatActivity {

    private ImageView imgBackbtn, imgMutebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_settingsview);

        imgBackbtn =findViewById(R.id.settings_backbtn);

        imgBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
