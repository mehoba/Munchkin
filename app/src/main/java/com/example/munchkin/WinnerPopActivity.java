package com.example.munchkin;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.luolc.emojirain.EmojiRainLayout;


public class WinnerPopActivity extends AppCompatActivity {

    private EmojiRainLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winnerpopupview);

        mContainer = (EmojiRainLayout)findViewById(R.id.winnerpopupview);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        //EmojiRain
        mContainer.addEmoji(R.drawable.trophy);
        mContainer.stopDropping();
        mContainer.setPer(10);
        mContainer.setDuration(7200);
        mContainer.setDropDuration(2400);
        mContainer.setDropFrequency(500);
        mContainer.startDropping();

    }
}
