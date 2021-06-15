package com.example.munchkin;

import android.view.View;
import android.widget.Toast;

import com.example.munchkin.Activity.SpielfeldActivity;
import com.example.munchkin.Karte.KartenTypen.Monsterkarte;
import com.example.munchkin.Karte.KartenTypen.Schatzkarte;
import com.example.munchkin.Networking.GameClient;

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

        //ToDo Funktionalität verfeinern
        //Soll die Stärke des Player und die Stärke des Monster vergleichen
        //Stärke des Player = Playerlevel + Ausrüstung + ev Buffs, die auf Player gespielt wurden
        //Stärke Monster= Monsterlevel + ev. Monsterbuffs + ev Buffs, die auf Monster gespielt wurden
        //Falls Player stärker - rufe kampfGewonnnen() auf
        //falls Monster stärker - rufe weglaufen() auf

        //Grundfunktionalität
        if (currentPlayer.getPlayerLevel().getLevel() > monster.getMonsterLevel()){
            kampfGewonnen();//Todo Ausrüstungslevel dazu zählen -> Vorher Ausrüstung ausimplementieren
        }else{
           kampfVerloren();
        }
    }

    public void kampfGewonnen(){
        currentPlayer.getPlayerLevel().levelIncrease(); //level erhöhen

        for (int i=0; i < monster.getAnzahlSchätze(); i++){     //es soll die getAnzahlSchätze auf Monster aufgerufen werden
            //und die entsprechende Anzahl von Schatzkarten gezogen werden
            currentPlayer.getInventar().getHandKarten().addKarte(Schatzkarte.getRandomSchatzkarte());
        }

        GamePhase.setPhase(GamePhase.Phase.nachKampfPhase);
        onKampfFinished();//Todo nachkampfphase ausprogrammieren. Am besten Frau Gassinger fragen
    }

    void kampfVerloren()
    {
        weglaufen();
    }

    public void weglaufen(){
        //TODO @Meho hier Würfelfunktion aufrufen, einbinden und ergebnis in ergebniswürfel speichern



    }

    public void weglaufen(int diceNumber){
        int ergebnisWürfel=diceNumber;

        if (ergebnisWürfel<=4){         //falls ergebnis 4 oder niedriger werden schlimmeDinge von Monster aufgerufen
            monster.schlimmeDinge();
        }
        //Falls ergebnis des Würfels 5 oder 6 (>4) war weglaufen erfolgreich
        onKampfFinished();
    }

    void onKampfFinished()
    {
        //Todo mehr als 5 cards? -> send per networking to weakest player
        Player.getLocalPlayer().setIstDran(false);
        GameClient.sendNextPlayerAnDerReihe();
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
