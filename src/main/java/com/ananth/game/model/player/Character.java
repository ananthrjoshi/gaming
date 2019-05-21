package com.ananth.game.model.player;

public interface Character {

    String getPlayerName();

    void initialize();

    void attack(Character opponent);

    Boolean isAlive();

    void setHealth(double health);

    Boolean defend(int opponentAttackPower);

    void reduceHealth(int opponentAttackPower,int opponentDefensePower);

    void gainFightExperience(String fightAct);
}
