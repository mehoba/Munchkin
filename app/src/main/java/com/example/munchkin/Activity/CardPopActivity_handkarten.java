package com.example.munchkin.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Karte.KartenSlot;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.R;
import com.example.munchkin.Spielfeld;

public class CardPopActivity_handkarten extends AppCompatActivity {
    private static KartenSlot kartenSlot;
    private static KartenSlot gehobenVonKartenSlot;


    public static void show(KartenSlot gehobenVonKartenSlot) {
        CardPopActivity_handkarten.gehobenVonKartenSlot = gehobenVonKartenSlot;

        Intent intentCardPopActivity = new Intent(SpielfeldActivity.getInstance().getApplicationContext(), CardPopActivity_handkarten.class);
        SpielfeldActivity.getInstance().startActivity(intentCardPopActivity);
    }


    void onBtnAusspielenClicked() {
        Karte karte = gehobenVonKartenSlot.karteHeben();
        Spielfeld.getAusgespielteKartenSlot().karteAblegen(karte);
        GameClient.sendKarteAufAbgelegtStapelGelegt(karte);
        finish();
    }

    void onBtnAblegenClicked() {
        if (gehobenVonKartenSlot.getKarte() instanceof Schatzkarte) {
            Spielfeld.getAblageStapelSchatzkartenSlot().karteAblegenWithoutTrigger(gehobenVonKartenSlot.karteHeben());
        } else {
            Spielfeld.getAblageStapelTürkartenSlot().karteAblegenWithoutTrigger(gehobenVonKartenSlot.karteHeben());
        }

        finish();
    }


    //----------------Juckt uns nimma---------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardpopview_handkarten);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.78), (int) (height * 0.78));

        kartenSlot = new KartenSlot(findViewById(R.id.cardpopView_handkarten_imgView));
        kartenSlot.setImageWithoutKarteAblegen(gehobenVonKartenSlot.getKarte());
        ImageView imgButtonAblegen = findViewById(R.id.cardpopup_btnAblegen);
        ImageView imgButtonAusspielen = findViewById(R.id.cardpopup_btnAusspielen);

        imgButtonAblegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnAblegenClicked();
            }
        });

        imgButtonAusspielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBtnAusspielenClicked();
            }
        });
    }
}
