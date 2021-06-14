package com.example.munchkin;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.munchkin.Activity.PlayerPopActivity;
import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Activity.TreasureCardActivity;

import org.w3c.dom.Text;

public class PlayerSideUI {

    //Reihenfolge: [0] = unten(localPlayer), [1] = rechts, [2] = links, [3] = oben
    private static PlayerSideUI[] playerSideUIArray = new PlayerSideUI[4];

    private final ImageView imgPlayerIcon;
    private final ImageView imgPlayerKlasse;
    private final ImageView imgPlayerRasse;
    private final TextView txtPlayerName;

    public PlayerSideUI(ImageView imgPlayerIcon, ImageView imgPlayerKlasse, ImageView imgPlayerRasse, TextView txtPlayerName, int index) {
        playerSideUIArray[index] = this;
        this.imgPlayerIcon = imgPlayerIcon;
        this.imgPlayerKlasse = imgPlayerKlasse;
        this.imgPlayerRasse = imgPlayerRasse;
        this.txtPlayerName = txtPlayerName;

        //Nur für local Player [War vorher halt so] TODO: Rasse und Klasse View + Klasse implementieren
        if(index == 0)
        {
            imgPlayerRasse.setOnClickListener(view -> {
                Intent intent=new Intent(SpielfeldActivity.getInstance().getApplicationContext(), TreasureCardActivity.class);//Todo Eigene Activity dafür entwerfen
                SpielfeldActivity.getInstance().startActivity(intent);
            });

            imgPlayerKlasse.setOnClickListener(view -> {
                Intent intent=new Intent(SpielfeldActivity.getInstance().getApplicationContext(), TreasureCardActivity.class);//Todo Eigene Activity dafür entwerfen
                SpielfeldActivity.getInstance().startActivity(intent);
            });
        }
        else
        {
            hideAll();
        }
    }

    public static void hideAllSidesExceptLocal()
    {
        playerSideUIArray[1].hideAll();
        playerSideUIArray[2].hideAll();
        playerSideUIArray[3].hideAll();
    }

    public void showAll() {
        SpielfeldActivity.getInstance().runOnUiThread(() -> {
            imgPlayerIcon.setVisibility(View.VISIBLE);
            imgPlayerKlasse.setVisibility(View.VISIBLE);
            imgPlayerRasse.setVisibility(View.VISIBLE);
            txtPlayerName.setVisibility(View.VISIBLE);
        });
    }

    void initializeUI(Player player)
    {
        imgPlayerIcon.setOnClickListener(view -> {
            PlayerPopActivity.show(player);
        });
        txtPlayerName.setText(player.getName());
    }

    public void hideAll() {
        SpielfeldActivity.getInstance().runOnUiThread(() -> {
            imgPlayerIcon.setVisibility(View.INVISIBLE);
            imgPlayerKlasse.setVisibility(View.INVISIBLE);
            imgPlayerRasse.setVisibility(View.INVISIBLE);
            txtPlayerName.setVisibility(View.INVISIBLE);
        });
    }

    public static PlayerSideUI getPlayerSideUI(int index) {
        return playerSideUIArray[index];
    }

    public ImageView getImgPlayerIcon()
    {
        return imgPlayerIcon;
    }
    public ImageView getImgPlayerKlasse()
    {
        return imgPlayerKlasse;
    }
    public ImageView getImgPlayerRasse()
    {
        return imgPlayerRasse;
    }
    public TextView getTxtPlayerName()
    {
        return txtPlayerName;
    }
}
