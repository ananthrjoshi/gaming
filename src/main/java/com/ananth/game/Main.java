package com.ananth.game;

import com.ananth.game.application.GameApplication;
import com.ananth.game.exception.GameException;

public class Main {

    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication();
        try {
            gameApplication.setupGame();
            gameApplication.loadGame();
        } catch (GameException e) {
            e.printStackTrace();
        }
    }
}
