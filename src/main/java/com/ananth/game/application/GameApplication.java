package com.ananth.game.application;

import com.ananth.game.exception.GameException;
import com.ananth.game.model.game.Battle;
import com.ananth.game.ui.GameGUI;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GameApplication {

    //private static final Logger logger = LoggerFactory.getLogger(GameApplication.class);

    //This property is used to setup the GUI for the application
    private GameGUI gameGUI;

    //Used to generate random numbers and can be used throughout the application
    public final static Random random = new Random();

    public GameGUI getGameGUI() {
        return gameGUI;
    }

    public void setGameGUI(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    public static Random getRandom() {
        return random;
    }

    /**
     * This method is used to load the battle game and start the game
     */
    private void loadGame() {

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Battle battle = new Battle();
        executor.execute(battle);
        executor.shutdown();
        while (!executor.isTerminated()) { }

    }

    /**
     * This method is used to initialize the Game application
     * @throws GameException exception
     */
    public void initalizeGameApplication() throws GameException {
        try {
            boolean isGameStarted = false;
            //method that shows menu options
            int option = gameGUI.showMenuOptions();
            do {
                switch (option) {
                    case 1:
                        System.out.println("====Loading the Game====");
                        isGameStarted = true;
                        break;
                    case 2:
                        System.out.println("====Exiting the application====");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Sorry, invalid option. Please choose a valid option");
                        option = gameGUI.showMenuOptions();
                        break;
                }
            } while (!isGameStarted);

            try {
                loadGame();
            } catch (Exception exception) {
                throw new GameException(exception);
            }
        } catch (Exception exception) {
            throw new GameException(exception);
        }

    }
}
