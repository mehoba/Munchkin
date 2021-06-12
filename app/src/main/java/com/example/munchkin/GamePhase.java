package com.example.munchkin;

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


}
