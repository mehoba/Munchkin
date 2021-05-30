package com.example.munchkin;

import com.example.munchkin.Karte.KartenTypen.MonsterKarte;

public class Kampf {
    //ToDo: Klasse ausimplementieren
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

    public void kämpfen(){
        //Soll vermutlich gestartet werden, sobald auf der UI der entsprechende Button gedrückt wurde
        //ToDo Funktionalität implementieren
        //Soll die Stärke des Player und die Stärke des Monster vergleichen
        //Stärke des Player = Playerlevel + Ausrüstung + ev Buffs, die auf Player gespielt wurden
        //Stärke Monster= Monsterlevel + ev. Monsterbuffs + ev Buffs, die auf Monster gespielt wurden
        //Falls Player stärkter - rufe kampfGewonnnen() auf
        //falls Monster stärker - rufe weglaufen() auf
    }

    public void kampfGewonnen(){
        //wenn Player stärker ist als Monster wird diese Funktion aufgerufen
        // ToDo:  Funktionalität implementieren
        //es soll die getAnzahlSchätze auf Monster aufgerufen werden
        //und die entsprechende Anzahl von Schatzkarten gezogen werden
    }

    public void weglaufen(){
        //wenn monster stärker oder button in UI gedrückt wird diese Funktion aufgerufen
        //ToDo:  Funktionalität implementieren
        //ruft würfelfunktion auf
        //Falls ergebnis des Würfels 5 oder 6 (>4) war weglaufen erfolgreich
        //falls ergebnis 4 oder niedriger werden schlimmeDinge von Monster aufgerufen
        }

}
