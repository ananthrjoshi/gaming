package com.ananth.game.constants;

/**
 * Holds the state / stage of the game
 */
public enum GameStage {

    GAME_START("START"),
    GAME_PAUSE("PAUSE"),
    GAME_RESUME("RESUME"),
    GAME_NOT_RUNNING("NOT RUNNING"),
    GAME_END("END");

    private String stage;
    GameStage(String stage) {
        this.stage = stage;
    }

    public String getStage() {
        return this.stage;
    }
}
