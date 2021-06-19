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
import com.example.munchkin.Karte.ListKartenSlot;
import com.example.munchkin.Networking.GameClient;
import com.example.munchkin.Player;
import com.example.munchkin.R;
import com.example.munchkin.Rasse;
import com.example.munchkin.Spielfeld;

public class CardPopActivity_handkarten extends AppCompatActivity {
    private static KartenSlot kartenSlotUI;//Only for UI. Should have no logic. Shows the image from listKartenSlot
    private static ListKartenSlot listKartenSlot;

    private static CardPopActivity_handkarten cardPopActivity_handkarten;
    private static boolean firstCardSold = true;

    public static void show(ListKartenSlot gehobenVonKartenSlot) {
        CardPopActivity_handkarten.listKartenSlot = gehobenVonKartenSlot;

        Intent intentCardPopActivity = new Intent(SpielfeldActivity.getInstance().getApplicationContext(), CardPopActivity_handkarten.class);
        SpielfeldActivity.getInstance().startActivity(intentCardPopActivity);
    }

    public static void resetCardSold() {
        firstCardSold = true;
    }

    void onBtnAusspielenClicked() {
        Karte karte = listKartenSlot.karteHeben();
        Spielfeld.getAusgespielteKartenSlot().karteAblegen(karte);
        GameClient.sendKarteAutStapelAusgespieltGelegt(karte);
        //gehobenVonKartenSlot.getHandKarten().removeKarte(gehobenVonKartenSlot.getListIndex());
        finish();
    }

    void onBtnAblegenClicked() {
        Karte karte = listKartenSlot.karteHeben();
        if (karte instanceof Schatzkarte) {
            Spielfeld.getAblageStapelSchatzkartenSlot().karteAblegenWithoutTrigger(karte);
        } else {
            Spielfeld.getAblageStapelTürkartenSlot().karteAblegenWithoutTrigger(karte);
        }
        GameClient.sendKarteAufAblagestapelGelegt(karte);
        //gehobenVonKartenSlot.getHandKarten().removeKarte(gehobenVonKartenSlot.getListIndex());
        finish();
    }

    void onBtnVerkaufenClicked() {
        Karte karte = listKartenSlot.karteHeben();

        if(karte instanceof Schatzkarte) {
            //GameClient.sendKarteAufAblagestapelGelegt(karte);
            Player player = Player.getLocalPlayer();
            // Only for the first card
            if(player.getRasse() == Rasse.HALBLING && firstCardSold) {
                firstCardSold = false;
                player.addGold(((Schatzkarte) karte).getGoldwert() * 2);
            } else {
                player.addGold(((Schatzkarte) karte).getGoldwert());
            }
            //listKartenSlot.getHandKarten().removeKarte(listKartenSlot.getListIndex());
            finish();
        }
    }

    //----------------Juckt uns nimma---------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        cardPopActivity_handkarten = this;
        setContentView(R.layout.cardpopview_handkarten);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.78), (int) (height * 0.78));

        kartenSlotUI = new KartenSlot(findViewById(R.id.cardpopView_handkarten_imgView));
        kartenSlotUI.setImageWithoutKarteAblegen(listKartenSlot.getKarte());
        ImageView imgButtonAblegen = findViewById(R.id.cardpopup_btnAblegen);
        ImageView imgButtonAusspielen = findViewById(R.id.cardpopup_btnAusspielen);
        ImageView imgButtonVerkaufen = findViewById(R.id.treasurecardpopup_btnverkaufen2);

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

        imgButtonVerkaufen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBtnVerkaufenClicked();
            }
        });
        if(Player.getLocalPlayer().getPlayerLevel().getLevel() >= 9 || !(listKartenSlot.getKarte() instanceof Schatzkarte)) {
            imgButtonVerkaufen.setVisibility(View.INVISIBLE);
        } else {
            imgButtonVerkaufen.setVisibility(View.VISIBLE);
        }
    }

    public static boolean istGeöffnet()
    {
        return getInstance() != null;
    }

    private static CardPopActivity_handkarten getInstance() {
        return cardPopActivity_handkarten;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cardPopActivity_handkarten = null;
    }
}
