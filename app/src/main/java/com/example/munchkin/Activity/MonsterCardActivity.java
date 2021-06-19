package com.example.munchkin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
import com.example.munchkin.R;

public class MonsterCardActivity extends AppCompatActivity {
    private static Monsterkarte monsterkarte;
    private ImageView imgMonsterkarte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monstercardview);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        imgMonsterkarte = findViewById(R.id.imgZombieCard);
        imgMonsterkarte.setImageResource(MonsterCardActivity.monsterkarte.getImage());
    }

    public static void show(Monsterkarte monsterkarte){
        MonsterCardActivity.monsterkarte = monsterkarte;


        Intent i=new Intent(SpielfeldActivity.getInstance().getApplicationContext(),MonsterCardActivity.class);
        SpielfeldActivity.getInstance().startActivity(i);

    }

}
