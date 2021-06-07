package com.example.munchkin.Activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.munchkin.Karte.Inventar;
import com.example.munchkin.Karte.Karte;
import com.example.munchkin.Player;
import com.example.munchkin.R;


public class TreasureCardActivity extends AppCompatActivity {
    private ImageView imgTreasureCard, btnAusruesten, btnWegwerfen;
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treasurecardpopview);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int)(height*0.85));

        imgTreasureCard=findViewById(R.id.cardpopView_handkarten_imgView);
        btnAusruesten=findViewById(R.id.treasurecardpopup_btnAusruesten);
        btnWegwerfen=findViewById(R.id.treasurecardpopup_btnWegwerfen);
        player=new Player();


        btnAusruesten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Karte karte: Inventar.getSchatzkartenList()){
                    //TODO
                }
            }
        });
    }
}
