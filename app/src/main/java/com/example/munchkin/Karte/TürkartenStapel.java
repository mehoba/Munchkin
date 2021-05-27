package com.example.munchkin.Karte;

import android.view.View;
import android.widget.ImageView;

public class TürkartenStapel extends KartenSlot {

    public TürkartenStapel(ImageView kartenImageView) {
        super(kartenImageView);
        kartenImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTürkartenStapelClicked();
            }
        });
    }

    @Override
    public Karte getKarte()
    {
        return KarteImpl.getRandomKarte();
    }//Todo Türkarte statt karte nehmen

    void onTürkartenStapelClicked()//Todo heben implementieren
    {

    }
}
