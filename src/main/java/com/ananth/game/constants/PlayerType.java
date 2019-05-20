package com.ananth.game.constants;

public enum PlayerType {

    USER("USER"),
    OPPONENT("OPPONENT");

    private String playerType;
    PlayerType(String playerType) {
        this.playerType = playerType;
    }

    public String getPlayerType() {
        return this.playerType;
    }
}
