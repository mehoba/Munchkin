package com.example.munchkin;

import com.example.munchkin.Networking.GameClient;

public class GamePhase
{
    private static Phase phase = Phase.vorbereitungsPhase;

    public enum Phase{
        vorbereitungsPhase,
        kampfPhase,
        nachKampfPhase
    };

    public static Phase getPhase() {
        return phase;
    }

    public static void setPhase(Phase phase) {
        GamePhase.phase = phase;
    }

    public static void rundeBeenden(){
        Player.getLocalPlayer().getInventar().getHandKarten().onFinishRound();
        Player.getLocalPlayer().setIstDran(false);
        GameClient.sendNextPlayerAnDerReihe();
    }


}
