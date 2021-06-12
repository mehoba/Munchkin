package com.example.munchkin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.R;

public class PopActivity extends AppCompatActivity {

    private ImageView muteBtn, vibrationBtn, licencesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupview);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.6),(int)(height*0.6));

        licencesBtn = findViewById(R.id.einstellungen_licencesBtn);

        licencesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LicencesActivity.class);
                startActivity(intent);
            }
        });

    }
}
