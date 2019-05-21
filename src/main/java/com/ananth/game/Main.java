package com.ananth.game;

import com.ananth.game.application.GameApplication;
import com.ananth.game.exception.GameException;
import com.ananth.game.ui.GameGUI;

public class Main {

    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication();
        try {
            gameApplication.setGameGUI(new GameGUI());
            gameApplication.initializeGameApplication();
        } catch (GameException e) {
            e.printStackTrace();
        }
    }
}
