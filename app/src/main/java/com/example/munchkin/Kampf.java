package com.example.munchkin;

import android.view.View;
import android.widget.Toast;

import com.example.munchkin.Activity.DiceActivity;
import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Karte.KartenTypen.Monsterkarte;

public class Kampf {
    /*
    * Soll sich Player suchen
    * und Monster suchen
    * Level und Ausrüstung von Player zusammenzählen
    * Monsterlevel und eventuell darauf gespielte MonsterBuffs
    * buffs die auf Monster oder Spieler gespielt werden
    *
    * Später weitere Monster die gespielt wurden
    * später weitere Spiele, die helfen suchen
    *
    * und den kampf auswerten
    *
    *
    * */

    //Variablen
    private Player currentPlayer;
    private Monsterkarte monster;


    public Kampf(Player currentPlayer, Monsterkarte monster){
        this.currentPlayer = currentPlayer;
        this.monster = monster;

        GamePhase.setPhase(GamePhase.Phase.kampfPhase);
        showButtons();

        SpielfeldActivity.getInstance().imgButtonKämpfen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kämpfen();
            }
        });

        SpielfeldActivity.getInstance().imgButtonWeglaufen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weglaufen();
            }
        });
    }

    public void kämpfen(){

        //Soll die Stärke des Player und die Stärke des Monster vergleichen
        //Stärke des Player = Playerlevel + Ausrüstung + ev Buffs, die auf Player gespielt wurden
        //Stärke Monster= Monsterlevel + ev. Monsterbuffs + ev Buffs, die auf Monster gespielt wurden
        //Falls Player stärker - rufe kampfGewonnnen() auf
        //falls Monster stärker - rufe weglaufen() auf

        //Grundfunktionalität
        int stärkePlayer= currentPlayer.getPlayerLevel().getLevel() + currentPlayer.getPlayerAusrüstung().getLevelSum();

        if (stärkePlayer > monster.getMonsterLevel()){
            kampfGewonnen();
        }else{
           kampfVerloren();
        }
    }

    public void kampfGewonnen(){
        Toast.makeText(SpielfeldActivity.getInstance(), "Kampf gewonnen", Toast.LENGTH_SHORT).show();
        currentPlayer.getPlayerLevel().levelIncrease(); //level erhöhen

        Spielfeld.getSchatzkartenStapel().setAnzahlErlaubtesZiehen(monster.getAnzahlSchätze());

        GamePhase.setPhase(GamePhase.Phase.nachKampfPhase);
        onKampfFinished();
    }

    void kampfVerloren(){
        Toast.makeText(SpielfeldActivity.getInstance(), "Kampf verloren - weglaufen gestartet", Toast.LENGTH_SHORT).show();
        weglaufen();
    }

    public void weglaufen(){
        hideButtons();
        DiceActivity.show(this);
    }

    public void weglaufen(int diceNumber){
        int ergebnisWürfel=diceNumber;
        int threshold = 4;
        if(currentPlayer.getRasse() == Rasse.ELF) threshold++;
        if (ergebnisWürfel<=threshold){         //falls ergebnis 4 oder niedriger werden schlimmeDinge von Monster aufgerufen
            Toast.makeText(SpielfeldActivity.getInstance(), "Weglaufen fehlgeschlagen", Toast.LENGTH_SHORT).show();
            monster.schlimmeDinge();
        }else{ //Falls ergebnis des Würfels 5 oder 6 (>4) war weglaufen erfolgreich
            Toast.makeText(SpielfeldActivity.getInstance(), "Weglaufen erfolgreich", Toast.LENGTH_SHORT).show();
        }

        onKampfFinished();
    }

    void onKampfFinished()
    {
        GamePhase.rundeBeenden();
        hideButtons();
    }

    void hideButtons()
    {
        SpielfeldActivity.getInstance().imgButtonKämpfen.setVisibility(View.INVISIBLE );
        SpielfeldActivity.getInstance().imgButtonWeglaufen.setVisibility(View.INVISIBLE);
    }

    void showButtons( )
    {
        SpielfeldActivity.getInstance().imgButtonKämpfen.setVisibility(View.VISIBLE);
        SpielfeldActivity.getInstance().imgButtonWeglaufen.setVisibility(View.VISIBLE);
    }

}
